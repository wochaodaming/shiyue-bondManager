package com.shiyue.bm.core.controller;

import com.shiyue.bm.core.basestruct.BaseResponse;
import com.shiyue.bm.core.log.CoreLog;
import com.shiyue.bm.core.mvc.interceptor.LoginInterceptor;
import com.shiyue.bm.core.mvc.interceptor.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/>
 * Created on 17/6/9.
 *
 * @auther lishenghao01
 */
@RestController
@RequestMapping(value = "/v2/account", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Account", description = "账号管理", tags = "Account")
public class AccountController {

    @PostMapping("login")
    @ApiOperation(value = "登陆", notes = "登陆", response = BaseResponse.class)
    public BaseResponse<String> login(@RequestBody LoginUser loginUser, HttpServletRequest request) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        CoreLog.getLogger().info(String.format("username=%s, password=%s", username, password));
        BaseResponse<String> baseResponse = new BaseResponse<>();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new RuntimeException("用户或密码为空");
        }
        User user = LoginInterceptor.getUserMap().get(username);
        if (user == null) {
            throw new RuntimeException("账号不存在");
        }
        if (password.equals(user.getPassword())) {
            UserSession session = new UserSession();
            session.setUsername(username);
            request.getSession().setAttribute("userToken", session);
            request.getSession().setMaxInactiveInterval(3000);

            baseResponse.setErrMsg("登陆成功");
            CoreLog.getLogger().info("登陆成功: " + username);
            return baseResponse;
        } else {
            throw new RuntimeException("密码错误");
        }
    }
}

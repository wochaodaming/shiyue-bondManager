package com.shiyue.bm.core.mvc.interceptor;

import com.shiyue.bm.core.controller.UserSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <br/>
 * Created on 17/6/9.
 *
 * @auther lishenghao01
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Map<String, User> userMap = new HashMap<String, User>() {
        {
            User admin = new User();
            admin.setUserName("admin");
            admin.setPassword("admin123");
            put(admin.getUserName(), admin);
        }
    };
    private final String loginUrl = "/web/login/login.html";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        if (request.getRequestURI().startsWith("/web/login/")
                || request.getRequestURI().startsWith("/web/base/")
                || request.getRequestURI().startsWith("/lib/")) {
            return true;
        }
        if (request.getRequestURI().startsWith("/web/")) {
            UserSession userSession = (UserSession) request.getSession().getAttribute("userToken");
            if (userSession != null) {
                return true;
            }
            response.sendRedirect(loginUrl);
        }
        return true;
    }

    public static Map<String, User> getUserMap() {
        return userMap;
    }
}

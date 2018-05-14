package com.shiyue.bm.core.mvc.interceptor;

import com.shiyue.bm.core.basestruct.BaseResponse;
import com.shiyue.bm.core.basestruct.Operator;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <br/>
 * Created on 16/11/6.
 *
 * @auther lishenghao01
 */
@Deprecated
public class ResponseDecorateInterceptor extends HandlerInterceptorAdapter {
    private static final ThreadLocal<Operator> opTL = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setRequestId(OperatorInterceptor.getOpTL().get().getRequestId());
//        response.getWriter().write();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    public static ThreadLocal<Operator> getOpTL() {
        return opTL;
    }
}


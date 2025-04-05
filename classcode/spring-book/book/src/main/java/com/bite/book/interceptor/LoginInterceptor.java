package com.bite.book.interceptor;

import com.bite.book.constant.Constans;
import com.bite.book.model.Result;
import com.bite.book.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("登录拦截器校验");
        //校验用户是否登录
        HttpSession session = request.getSession(false);//true表示没有session就创建，false表示没有就直接返回
        if(session != null && session.getAttribute(Constans.SESSION_USER_KEY)!=null){
            UserInfo userInfo = (UserInfo) session.getAttribute(Constans.SESSION_USER_KEY);
            if (userInfo!=null && userInfo.getId()>=0 ){
                return true;
            }
        }
        response.setStatus(401);//表示未登录
        return false;//放行  false表示拦截
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("LoginInterceptor ⽬标⽅法执⾏后执⾏");
    }

}

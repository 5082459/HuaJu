package com.HuJuHomePage.config;

import com.HuJuHomePage.models.Student;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        System.out.println("请求：" + request.getRequestURI());
        if (user == null) {
            //未登录,返回登录页面
            response.sendRedirect("/HuaJu/login.html");
            System.out.println("未登录");
            return false;
        }else {
            Student student = (Student)user;
            System.out.println(student.getName() + "已登录");
            //放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}

//package com.swun.interceptor;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
////拦截器
//public class LoginInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpSession session=request.getSession();
//        if(session.getAttribute("loginInfo")!=null)
//            return true;
//
//        request.getRequestDispatcher("/index.html").forward(request,response);
//        return false;
//
//    }
//
//
//}

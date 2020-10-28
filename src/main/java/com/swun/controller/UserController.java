package com.swun.controller;


import com.swun.domain.User;
import com.swun.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("regist")
    public String regist(User user){
        int status;
        status=userService.regist(user);
        return "page1";
    }

    @RequestMapping("login")
    public String login(User user, HttpSession session){
        int status;
        status=userService.login(user);
        if(status==1)
            session.setAttribute("loginInfo",user);
        return "login";
    }

    //测试拦截器
    @RequestMapping("testInterceptor")
    public String testInterceptor(){

        return "page1";
    }

}

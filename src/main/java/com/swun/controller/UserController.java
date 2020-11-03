package com.swun.controller;


import com.swun.domain.User;
import com.swun.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin(allowCredentials = "true" ,allowedHeaders = "*",maxAge = 3600)
@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/regist")
    public String regist(User user){
        int status;
        status=userService.regist(user);
        return null;
    }
    @ResponseBody
    @RequestMapping("/login")
    public int login(@RequestBody User user, HttpSession session){
        int status;
        status=userService.login(user);
        if(status==1){
            session.setAttribute("loginInfo",user);
            return 200;
        }
        return 400;
    }


}

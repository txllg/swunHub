package com.swun.controller;

import com.swun.domain.User;
import com.swun.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("regist")
    public String regist(User user){
        userService.regist(user);
        return "";
    }

    @RequestMapping("login")
    public String login(User user){

        return "";
    }

}

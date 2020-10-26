package com.swun.controller;

import com.swun.domain.User;
import com.swun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("register")
    public String regist(User user){
        userService.regist(user);
        return "";
    }

}

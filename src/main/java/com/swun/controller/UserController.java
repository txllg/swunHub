package com.swun.controller;

import com.swun.domain.User;
import com.swun.service.UserService;
import com.swun.service.inte.IGitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
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

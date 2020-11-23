package com.swun.controller;


import com.swun.domain.User;
import com.swun.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(allowCredentials = "true" ,allowedHeaders = "*",maxAge = 3600)
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/regist")
    public int regist(@RequestBody User user){
        int status;
        status=userService.regist(user);
        System.out.println("regist方法");
        if(status==1)//注册成功
            return 200;
        System.out.println("注册失败");
        return 400;//注册失败
    }

    @ResponseBody
    @RequestMapping("/login")
    public int login(@RequestBody User user){
        int status;
        status=userService.login(user);
        System.out.println("login方法");
        if(status==1)//登录成功
            return 200;


        return 400;//登录失败
    }

}


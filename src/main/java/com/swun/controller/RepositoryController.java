package com.swun.controller;

import com.swun.domain.UserRepository;
import com.swun.service.impl.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowCredentials = "true" ,allowedHeaders = "*",maxAge = 3600)
@Controller
public class RepositoryController {

    @Autowired
    private UserRepositoryService userRepositoryService;

    //添加仓库
    @ResponseBody
    @RequestMapping("/addRepository")
    public int addRepository(@RequestParam String username,String repositoryName){
        UserRepository userRepository=new UserRepository();
        userRepository.setUsername(username);
        userRepository.setRepositoryName(repositoryName);
        int status=userRepositoryService.addRepository(userRepository);
        if(status==1)
            return 200;

        return 400;
    }

    //删除仓库
    @ResponseBody
    @RequestMapping("/deleteRepository")
    public void deleteRepository(@RequestParam String username,String repositoryName){
        UserRepository userRepository=new UserRepository();
        userRepository.setUsername(username);
        userRepository.setRepositoryName(repositoryName);
        userRepositoryService.deleteRepository(userRepository);
    }

    //根据用户名查询仓库
    @ResponseBody
    @GetMapping("/findRepository")
    public List<String> findRepositoryByUsername(@RequestParam String username){
        List<String> res=userRepositoryService.findRepositoryByUsername(username);
        for(String e:res)
            System.out.println(e);
        return res;
    }

}

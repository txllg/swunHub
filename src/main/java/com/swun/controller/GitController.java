package com.swun.controller;


import com.swun.service.IGitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
public class GitController {

    @Autowired
    IGitService gitService;
    @ResponseBody
    @GetMapping("/pullBranchToLocal")
    public void pullBranchToLocal(@RequestParam String branch,@RequestParam String username){
        System.out.println("access");
//        gitService.pullBranchToLocal(branch,username);
    }
}

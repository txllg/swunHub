package com.swun.controller;


import com.swun.service.inte.IGitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class GitController {

    @Autowired
    IGitService gitService;

    @ResponseBody
    @GetMapping("/pullBranchToLocal")
    public void pullBranchToLocal(@RequestParam String branch,@RequestParam String username){
        gitService.pullBranchToLocal(branch,username);
    }
}

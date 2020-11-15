package com.swun.controller;


import com.swun.domain.RepoFile;
import com.swun.service.IGitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
public class GitController {

    @Autowired
    IGitService gitService;

    @ResponseBody
    @GetMapping("/pullBranchToLocal")
    public void pullBranchToLocal(@RequestParam String branch,@RequestParam String username){
        gitService.pullBranchToLocal("yang",branch,username);
    }
    @ResponseBody
    @GetMapping("/checkoutBranch")
    public List<RepoFile> checkoutBranch(String username, String repository, String branch){
        return gitService.checkoutBranch(branch,username,repository);
    }
}

package com.swun.controller;

import com.swun.domain.RepoFile;
import com.swun.service.IRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
public class RepoController {
    @Autowired
    IRepoService repoService;
    @ResponseBody
    @GetMapping("/getRepositoryFile")
    public List<RepoFile> getRepositoryFile(@RequestParam String path){
        return repoService.getFile(path);
    }
}

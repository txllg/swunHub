package com.swun.service.impl;

import com.swun.service.inte.IGitService;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.stereotype.Service;

import java.io.File;

@Service("IGitService")
public class GitServiceImpl implements IGitService {
    //本地git路径
    public String LOCALPATH = "D:/user/yang/";
    //.git文件路径
    public String LOCALGITPATH = LOCALPATH + ".git";
    public String USER = "git";
    public String PASSWORD = "bb112233";
    //远程主机
    public String HOST = "192.168.236.11";
    public String RemoteRepoUri = "git@192.168.236.11:/home/gitrepo/sample.git";
    //建立本地仓库
    @Override
    public void setupRepo() {
        try {
            Git.cloneRepository()
                    .setURI(RemoteRepoUri)
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider(USER,PASSWORD))
                    .setBranch("master")
                    .setDirectory(new File(LOCALPATH)).call();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void pullBranchToLocal(String branch,String username) {
        Git git;
        try {
            setupRepo();
            git = new Git(new FileRepository(LOCALPATH));
            git.pull().setRemoteBranchName("master")
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider(USER,PASSWORD)).call();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void checkoutBranch(String branch) {
        try {

        }catch (Exception e){

        }
    }


}

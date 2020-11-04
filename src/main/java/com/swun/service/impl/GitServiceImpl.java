package com.swun.service.impl;


import com.jcraft.jsch.Session;
import com.swun.service.IGitService;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.transport.JschConfigSessionFactory;
import org.eclipse.jgit.transport.OpenSshConfig;
import org.eclipse.jgit.transport.SshSessionFactory;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.stereotype.Service;

import java.io.File;

@Service("IGitService")
public class GitServiceImpl implements IGitService {
    //本地git路径
    public String LOCALPATH = "D:/user/yang";
    //.git文件路径
    public String LOCALGITPATH = LOCALPATH + "/.git";
    public String USER = "git";
    public String PASSWORD = "bb112233";
    //远程主机
    public String HOST = "192.168.236.11";
    public String RemoteRepoUri = "git@192.168.236.11:/home/gitrepo/sample.git";
    //建立本地仓库
    @Override
    public void cloneToLocal(String username,String repository) {
        try {
            JschConfigSessionFactory jschConfigSessionFactory = new JschConfigSessionFactory() {
                @Override
                protected void configure (OpenSshConfig.Host hc, Session session) {
                    try {

                        session.setConfig("StrictHostKeyChecking","no");
                        session.setPassword(PASSWORD);
                        //设置连接超时 解决auth fail 报错
                        session.setConfig("userauth.gssapi-with-mic", "no");
                        session.connect();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            SshSessionFactory.setInstance(jschConfigSessionFactory);
            this.LOCALPATH = "D:/user/"+username+"/"+repository;
            this.LOCALGITPATH = LOCALPATH + "/.git";

            Git.cloneRepository()
                    .setURI(RemoteRepoUri)
                    .setBranch("master")
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider(USER,PASSWORD))
                    .setDirectory(new File(LOCALPATH)).call();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void pullBranchToLocal(String repository,String branch,String username) {

        try {
            Git git;
            git = new Git(new FileRepository(LOCALGITPATH));
            git.pull()
                    .setRemote("origin")
                    .setRemoteBranchName(branch)
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider(USER,PASSWORD))
                    .call();
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

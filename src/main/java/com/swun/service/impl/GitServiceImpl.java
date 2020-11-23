package com.swun.service.impl;


import com.jcraft.jsch.Session;
import com.swun.domain.RepoFile;
import com.swun.service.IGitService;
import com.swun.service.IRepoService;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.transport.JschConfigSessionFactory;
import org.eclipse.jgit.transport.OpenSshConfig;
import org.eclipse.jgit.transport.SshSessionFactory;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service("IGitService")
public class GitServiceImpl implements IGitService {
    //本地git路径
    public String LOCALPATH;
    //.git文件路径
    public String LOCALGITPATH;
    public String USER = "git";
    public String PASSWORD = "bb112233";
    //远程主机
    public String HOST = "git@192.168.236.11";
    public String RemoteRepoUri = "git@192.168.236.11:/home/gitrepo/";
    //建立本地仓库
    private void conn() {
        try {
            JschConfigSessionFactory jschConfigSessionFactory = new JschConfigSessionFactory() {
                @Override
                protected void configure(OpenSshConfig.Host hc, Session session) {
                    try {

                        session.setConfig("StrictHostKeyChecking", "no");
                        session.setPassword(PASSWORD);
                        //设置连接超时 解决auth fail 报错
                        session.setConfig("userauth.gssapi-with-mic", "no");
                        session.connect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            SshSessionFactory.setInstance(jschConfigSessionFactory);
        }catch (Exception e1) {
        }
    }
    @Override
    public void cloneToLocal(String username,String repository) {
        conn();
            try {
                this.LOCALPATH = "D:/user/"+username+"/"+repository;
                this.LOCALGITPATH = LOCALPATH + "/.git";
                this.RemoteRepoUri += username+"/"+repository+".git";
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
    conn();
        this.LOCALPATH = "D:/user/"+username; //+"/"+repository;
        this.LOCALGITPATH = LOCALPATH + "/.git";
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
    public List<RepoFile> checkoutBranch(String branch, String username, String repository) {
        conn();
        try {
            this.LOCALPATH = "D:/user/"+username; //+"/"+repository;
            this.LOCALGITPATH = LOCALPATH + "/.git";
            Git git = new Git(new FileRepository(LOCALGITPATH));
            if(branchNameExist(git,branch)){
                //如果分支存在，切换分支
                git.checkout().setCreateBranch(false).setName(branch);
            }else{
                //分支不存在，创建分支
                git.checkout().setCreateBranch(true).setName(branch);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        IRepoService repoService = new RepoService();
        return repoService.getFile(LOCALPATH);
    }
    public boolean branchNameExist(Git git, String branchName) throws GitAPIException {
        List<Ref> refs = git.branchList().call();
        for (Ref ref : refs) {
            if (ref.getName().contains(branchName)) {
                return true;
            }
        }
        return false;
    }


}

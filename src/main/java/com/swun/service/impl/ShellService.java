package com.swun.service.impl;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import com.swun.service.IShellService;
import org.springframework.stereotype.Service;

@Service
public class ShellService implements IShellService {
    private Connection connection;
    private String ip = "192.168.236.11";
    private String osUsername = "root";
    private String password = "bb112233";

    @Override
    public void login() {
        try {
            connection = new Connection(ip);
            connection.connect();
            connection.authenticateWithPassword(osUsername,password);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void createRepo(String username, String repoName) {
        String command = "/home/gitScript/createRepo.sh"+" " +username +" "+repoName+".git";
        try{
            Session session = connection.openSession();
            session.execCommand(command);
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}

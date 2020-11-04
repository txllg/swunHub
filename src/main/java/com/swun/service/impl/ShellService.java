package com.swun.service.impl;

import ch.ethz.ssh2.Connection;
import com.swun.service.IShellService;

public class ShellService implements IShellService {
    private Connection connection;
    private String ip = "192.168.236.11";
    private String osUsername = "root";
    private String password = "bb112233";

    @Override
    public void login() {
        try {
            connection = new Connection(ip);
            connection.authenticateWithPassword(osUsername,password);
            connection.connect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void createRepo(String username, String repoName) {

    }
}

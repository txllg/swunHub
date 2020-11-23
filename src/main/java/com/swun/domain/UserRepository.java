package com.swun.domain;

import java.io.Serializable;

public class UserRepository implements Serializable {
    private String repositoryName;
    private String username;

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "repositoryName='" + repositoryName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

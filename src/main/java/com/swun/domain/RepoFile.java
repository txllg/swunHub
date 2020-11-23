package com.swun.domain;

public class RepoFile {
    private String name;
    private String isFile = "false";


    public RepoFile(String name){
        this.name = name;
    }

    public String getIsFile() {
        return isFile;
    }

    public void setIsFile(String isFile) {
        this.isFile = isFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

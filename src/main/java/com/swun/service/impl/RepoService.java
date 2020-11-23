package com.swun.service.impl;

import com.swun.domain.RepoFile;
import com.swun.service.IRepoService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepoService implements IRepoService {
    @Override
    public List<RepoFile> getFile(String path) {
        List<RepoFile> files = new ArrayList<>();
        try {
            File file = new File(path);
            File[] tempList = file.listFiles();
            try {
                for(File f : tempList){
                    files.add(new RepoFile(f.getName()));
                }
            }catch (NullPointerException ne){
                String name = "";
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String strLine = null;
                    int lineCount = 1;
                    while(null != (strLine = bufferedReader.readLine())){
                        name += strLine;
                        name += "\n";
                        lineCount++;
                    }
                    RepoFile file1 = new RepoFile(name);
                    file1.setIsFile("true");
                    files.add(file1);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(files.size() == 0){
                files.add(new RepoFile("空文件夹"));
            }
        }catch (Exception e){

        }
        return files;
    }
}

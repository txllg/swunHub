package com.swun.service.impl;

import com.alibaba.druid.util.Utils;
import com.swun.dao.IUserRepositoryDao;
import com.swun.domain.UserRepository;
import com.swun.service.IUserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryService implements IUserRepositoryService{

    @Autowired
    private static IUserRepositoryDao userRepositoryDao;

    public static IUserRepositoryDao getUserRepositoryDao(){
        return userRepositoryDao;
    }

    @Autowired
    public void setUserRepositoryDao(IUserRepositoryDao userRepositoryDao){
        UserRepositoryService.userRepositoryDao=userRepositoryDao;
    }



    public int addRepository(UserRepository userRepository){
        int status=UserRepositoryService.SearchRepository(userRepository);
        if(status==1)//同名仓库已经存在
            return 0;//添加失败

        userRepositoryDao.addRepository(userRepository);//仓库不存在
        return 1;//添加成功
    }

    public int deleteRepository(UserRepository userRepository){
        int status=UserRepositoryService.SearchRepository(userRepository);
        if(status==0)//仓库不存在
            return 0;//删除失败

        userRepositoryDao.deleteRepository(userRepository);
        return 1;//删除成功
    }



    public List<String> findRepositoryByUsername(String username){
        List<String> list=userRepositoryDao.findRepositoryByUsername(username);
        return list;
    }


    public static int SearchRepository(UserRepository userRepository) {
        String username=userRepository.getUsername();
        List<String> list= userRepositoryDao.findRepositoryByUsername(username);
        for(String e:list)
            if(userRepository.getRepositoryName().equals(e))
                return 1;//该用户下的该名称仓库存在
        return 0;//不存在
    }
}

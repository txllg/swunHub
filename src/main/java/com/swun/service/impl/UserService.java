package com.swun.service.impl;

import com.swun.dao.IUserDao;
import com.swun.domain.User;
import com.swun.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public int regist(User user){
        List<User> userList=userDao.findAll();
        for(User e:userList)
            if(e.getUsername().equals(user.getUsername()))
                return 0;//用户名已经存在，注册失败

        userDao.regist(user);//注册成功
        return 1;
    }

    @Override
    public int login(User user) {
        List<User> userList=userDao.findAll();
        for(User e:userList)
            if((e.getUsername().equals(user.getUsername()))&&(e.getPassword().equals(user.getPassword())))
                return 1;//用户名和密码正确，登录成功

        return 0;//登录失败
    }


}

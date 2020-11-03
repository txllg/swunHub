package com.swun.service.impl;

import com.swun.dao.IUserDao;
import com.swun.domain.User;
import com.swun.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public int regist(User user){
        List<User> userList=userDao.findAll();
        for(User e:userList)
            if(e.getUsername().equals(user.getUsername()))
                return 0;
        userDao.regist(user);
        return 1;
    }

    @Override
    public int login(User user) {
        List<User> userList=userDao.findAll();
        System.out.println(userList);
        for(User e:userList)
            if((e.getUsername().equals(user.getUsername()))&&(e.getPassword().equals(user.getPassword())))
                return 1;

        return 0;
    }


}

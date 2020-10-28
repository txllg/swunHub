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
    public void regist(User user){
        userDao.regist(user);
    }

    @Override
    public void login(User user) {
        List<User> userList=userDao.findAll();
        for(User e:userList){
            if((e.getUsername().equals(user.getUsername()))&&(e.getPassword().equals(user.getPassword())))
                return;

        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}

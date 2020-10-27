package com.swun.service;

import com.swun.dao.IUserDao;
import com.swun.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    @Autowired
    private IUserDao userDao;

    public void regist(User user){

        userDao.regist(user);
    }

}

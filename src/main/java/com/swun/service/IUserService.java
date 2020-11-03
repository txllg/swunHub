package com.swun.service;

import com.swun.domain.User;

public interface IUserService {
    public int regist(User user);

    public int login(User user);

}

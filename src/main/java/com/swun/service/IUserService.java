package com.swun.service;

import com.swun.domain.User;

import java.util.List;

public interface IUserService {
    public int regist(User user);

    public int login(User user);

}

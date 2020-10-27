package com.swun.service;

import com.swun.domain.User;

import java.util.List;

public interface IUserService {
    public void regist(User user);

    public void login(User user);

    public List<User> findAll();
}

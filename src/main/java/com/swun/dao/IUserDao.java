package com.swun.dao;

import com.swun.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    void regist(User user);
    List<User> findAll();
}

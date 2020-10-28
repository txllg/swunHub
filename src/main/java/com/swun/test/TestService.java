package com.swun.test;

import com.swun.domain.User;
import com.swun.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class TestService {
    @Autowired
    private UserService userService;

    @Test
    public void testRegist(){
        User user=new User();
        user.setUsername("hahaha");
        user.setPassword("12138");
        userService.regist(user);

    }
}

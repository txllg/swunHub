package com.swun;

import com.swun.dao.IUserDao;
import com.swun.domain.User;
import com.swun.service.IShellService;
import com.swun.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SwunHubApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private IUserDao dao;
    @Autowired
    private IShellService shellService;


    @Test//service层
    void testRegist2() {
            int res;
            User user=new User();
            user.setUsername("hahaha");
            user.setPassword("12138");
            res=userService.regist(user);
            if(res==1)
                System.out.println("插入数据成功");
            else if(res==0)
                System.out.println("插入数据失败");
    }



    @Test//dao层
    public void testRegist1(){
        User user=new User();
        user.setUsername("txl");
        user.setPassword("123");
        dao.regist(user);

    }


}

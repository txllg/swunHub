package com.swun;


import com.swun.dao.IUserDao;

import com.swun.dao.IUserRepositoryDao;
import com.swun.domain.User;
import com.swun.domain.UserRepository;
import com.swun.service.IUserRepositoryService;
import com.swun.service.impl.UserRepositoryService;
import com.swun.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SwunHubApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private IUserDao dao;

    @Autowired
    private IUserRepositoryDao userRepositoryDao;

    @Autowired
    private UserRepositoryService userRepositoryService;



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

    @Test
    public void testIRepositoryDao(){
        UserRepository r1=new UserRepository();
        UserRepository r2=new UserRepository();
        r1.setUsername("txl");
        r1.setRepositoryName("r1");
        r2.setUsername("hahaha");
        r2.setRepositoryName("r2");
        userRepositoryDao.addRepository(r1);
        userRepositoryDao.addRepository(r2);


        List<String> list=userRepositoryDao.findRepositoryByUsername("txl");
        for(String e:list)
            System.out.println(e);
        userRepositoryDao.deleteRepository(r1);
        userRepositoryDao.deleteRepository(r2);

    }

    //service层仓库
    @Test
    public void testRepositoryService(){


//        添加仓库
        UserRepository r1=new UserRepository();
        r1.setUsername("u3");
        r1.setRepositoryName("r2");

        UserRepository r2=new UserRepository();
        r2.setUsername("u3");
        r2.setRepositoryName("r3");
        userRepositoryService.addRepository(r2);

        if(userRepositoryService.addRepository(r1)==1)
        System.out.println("仓库添加成功");
            else System.out.println("仓库添加失败");

        //删除仓库
//        UserRepository r1=new UserRepository();
//        r1.setUsername("u1");
//        r1.setRepositoryName("r1");
//        UserRepository r2=new UserRepository();
//        r2.setUsername("u2");
//        r2.setRepositoryName("r2");
//        int m=userRepositoryService.deleteRepository(r2);
//        if(m==1)
//            System.out.println("删除成功");
//        else System.out.println("此仓库不存在，删除失败");

        //查询
        List<String> list=userRepositoryService.findRepositoryByUsername("u3");
        for(String e:list)
            System.out.println(e);

    }

    @Test
    public void testRepositoryController(){

    }

}

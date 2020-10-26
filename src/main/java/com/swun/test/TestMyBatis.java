package com.swun.test;


import com.swun.dao.IUserDao;
import com.swun.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")

public class TestMyBatis {

    private InputStream in;
    SqlSessionFactory factory;
    private SqlSession sqlSession;

//    @Autowired
    private IUserDao dao;

    @Before
    public void init() throws IOException {
//        读取配置文件
        in= Resources.getResourceAsStream("MybatisConfig.xml");
//        获取工厂对象
        factory=new SqlSessionFactoryBuilder().build(in);
//        利用工厂获取sqlSession对象
        sqlSession=factory.openSession();
//        最后利用SqlSession对象获取dao对象
        dao=sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void testRegist(){
       User user=new User();
       user.setUsername("txl");
       user.setPassword("123");
//       dao.regist(user);
       List<User> users=dao.showAll();
       for(User user1:users)
           System.out.println(user1);
    }

}

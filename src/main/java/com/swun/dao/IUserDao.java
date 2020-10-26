package com.swun.dao;

import com.swun.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUserDao {

    @Insert("insert into user(`username`,`password`) values(#{username},#{password})")
    public void regist(User user);

    @Select("select * from user")
    public List<User> showAll();
}

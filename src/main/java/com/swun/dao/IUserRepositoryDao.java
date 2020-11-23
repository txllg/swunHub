package com.swun.dao;

import com.swun.domain.UserRepository;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IUserRepositoryDao {

    @Insert("insert into repository(`username`,`repositoryName`) values(#{username},#{repositoryName})")
    public void addRepository(UserRepository userRepository);

    @Delete("delete from repository where username=#{username} and repositoryName=#{repositoryName}")
    public void deleteRepository(UserRepository userRepository);

    @Select("select repositoryName from repository where username=#{username}")
    public List<String> findRepositoryByUsername(String username);


}

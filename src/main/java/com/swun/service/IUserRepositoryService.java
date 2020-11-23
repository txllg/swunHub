package com.swun.service;

import com.swun.dao.IUserRepositoryDao;
import com.swun.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IUserRepositoryService {

    public int addRepository(UserRepository userRepository);

    public int deleteRepository(UserRepository userRepository);

    public List<String> findRepositoryByUsername(String username);

    public static int searchRepository(){return 0;}

}

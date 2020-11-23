package com.swun;

import com.swun.service.IShellService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class createRepoTest {
    @Autowired
    IShellService shellService;
    @Test
    public void createRepo(){
        shellService.login();
        shellService.createRepo("yang","test");
    }
}

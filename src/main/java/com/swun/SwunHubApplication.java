package com.swun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.swun.dao")
public class SwunHubApplication {

    public static void main(String[] args) {

        SpringApplication.run(SwunHubApplication.class, args);
    }

}

package com.shuai.springbootproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shuai.springbootproject.dao")
public class SpringbootprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootprojectApplication.class, args);
    }

}

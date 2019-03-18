package com.shuai.springbootproject.controller;

import com.shuai.springbootproject.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    private UserService userService;
    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public String hello(){
        return "hello shuai";
    }
    @RequestMapping(value="/helloDB",method = RequestMethod.GET)
    public String helloUser(){
        return userService.selectUserByID("F2E4520DB78B4D66B8B7F7578A05C6E3").toString();
    }
}

package com.shuai.springbootproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jump")
public class JumpController {
    @RequestMapping("/toRedis")
    public String jumpRedis(){
        return "testRedis";
    }
}

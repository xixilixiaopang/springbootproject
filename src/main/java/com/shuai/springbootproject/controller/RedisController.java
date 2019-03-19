package com.shuai.springbootproject.controller;

import com.shuai.springbootproject.util.RedisUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
public class RedisController {
    @Resource
    public RedisUtil redisUtil;

    @RequestMapping(value ="/getRedis/{key}" ,method=RequestMethod.GET)
    public String testRedis(@PathVariable String key){
        return redisUtil.get(key).toString();
    }
    @RequestMapping(value = "/setRedis" ,method =RequestMethod.POST)
    public void setRedis(@RequestParam(value="key") String key,@RequestParam(value="value") String value ){
        redisUtil.set(key,value);
    }

}

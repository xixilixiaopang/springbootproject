package com.shuai.springbootproject.service.Impl;

import com.shuai.springbootproject.dao.UserDao;
import com.shuai.springbootproject.entity.User;
import com.shuai.springbootproject.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userdao;

    public User selectUserByID(String id) {
        return userdao.selectbyId(id);
    }
}

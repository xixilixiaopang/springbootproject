package com.shuai.springbootproject.dao;

import com.shuai.springbootproject.entity.User;

public interface UserDao {
    User selectbyId(String id);
}
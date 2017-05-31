package com.demo.shiro.service;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shiro.dao.UserDao;
import com.demo.shiro.entity.UserEntity;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserEntity getUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @RequiresRoles(value = { "role1" })
    public String testPermission() {
        return "This is a test for permission service...";
    }
}

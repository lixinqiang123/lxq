package com.lxq.api.service.impl;

import com.lxq.api.dao.UserDao;
import com.lxq.api.entity.po.User;
import com.lxq.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl implements UserService {


    //注入
    @Autowired
    private UserDao userDao;


    @Override
    public User queryUser(String name) {
        return userDao.queryUser(name);
    }

    //新增
    @Override
    public void addUser(User user) {

        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        userDao.addUser(user);
    }

    //查询
    @Override
    public User queryUserByName(String username) {

        return userDao.queryUserByName(username);
    }
}

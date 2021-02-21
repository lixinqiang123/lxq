package com.lxq.api.service;

import com.lxq.api.entity.po.User;

public interface UserService {
    User queryUser(String name);

    void addUser(User user);

    User queryUserByName(String username);
}

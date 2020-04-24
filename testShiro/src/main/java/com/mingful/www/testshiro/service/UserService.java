package com.mingful.www.testshiro.service;

import com.mingful.www.testshiro.entity.User;

public interface UserService {
    /**
     * 通过用户名找用户信息
     *
     * @param username 用户名
     * @return User
     */
    User findUserByName(String username);

    /**
     * 保存用户
     *
     * @param user 用户信息
     * @return boolean
     */
    boolean saveUser(User user);
}

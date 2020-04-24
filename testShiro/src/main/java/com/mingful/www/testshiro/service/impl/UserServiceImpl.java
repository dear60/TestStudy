package com.mingful.www.testshiro.service.impl;

import com.mingful.www.testshiro.dao.UserDao;
import com.mingful.www.testshiro.entity.User;
import com.mingful.www.testshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao = new UserDao();

    @Override
    public User findUserByName(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user) > 0;
    }
}

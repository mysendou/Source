package com.aug.jma.service.impl;

import com.aug.jma.dao.UserDao;
import com.aug.jma.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = null;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }

}

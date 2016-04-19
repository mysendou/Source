package com.aug.jma.dao.impl;

import com.aug.jma.dao.UserDao;

public class UserMysqlDaoImpl implements UserDao{

    @Override
    public void getUser() {
        System.out.println("Get the User by mysql");
    }

}

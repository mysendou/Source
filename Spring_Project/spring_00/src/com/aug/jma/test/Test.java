package com.aug.jma.test;

import com.aug.jma.dao.impl.UserMysqlDaoImpl;
import com.aug.jma.dao.impl.UserOrcaleDaoImpl;
import com.aug.jma.service.impl.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserMysqlDaoImpl());
        userService.getUser();
        userService.setUserDao(new UserOrcaleDaoImpl());
        userService.getUser();
    }
}

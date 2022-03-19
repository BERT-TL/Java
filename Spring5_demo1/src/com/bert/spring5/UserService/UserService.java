package com.bert.spring5.UserService;

import com.bert.spring5.UserDao.UserDao;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void testService() {
        System.out.println("Service add......");
        userDao.testDao();
    }
}

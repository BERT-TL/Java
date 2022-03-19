package com.bert.spring5.Dao;

import org.springframework.stereotype.Repository;

//@Repository
@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("dao....");
    }
}

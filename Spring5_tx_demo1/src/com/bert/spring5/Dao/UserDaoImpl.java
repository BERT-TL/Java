package com.bert.spring5.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //少钱
    @Override
    public void decreaseMoney() {
        String sql = "update t_user set usermoney=usermoney-? where username=?;";
        jdbcTemplate.update(sql, 100, "lucy");
    }

    //多钱
    @Override
    public void increaseMoney() {
        String sql = "update t_user set usermoney=usermoney+? where username=?;";
        jdbcTemplate.update(sql, 100, "mary");
    }


}

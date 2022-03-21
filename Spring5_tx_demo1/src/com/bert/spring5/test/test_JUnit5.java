package com.bert.spring5.test;


import com.bert.spring5.Service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean1.xml")
@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class test_JUnit5 {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.testAccount();
    }
}

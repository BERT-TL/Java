package com.bert.spring5.testDemo;

import com.bert.spring5.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testDemo {

    @Test
    public void test()
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println(userService);
        userService.add();
    }
}

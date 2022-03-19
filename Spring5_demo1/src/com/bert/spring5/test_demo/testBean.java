package com.bert.spring5.test_demo;

import com.bert.spring5.Bean.Emp;
import com.bert.spring5.Book;
import com.bert.spring5.Orders;
import com.bert.spring5.User;
import com.bert.spring5.UserService.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBean {

    @Test
    public void testService(){
        //记载spring的配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");

        //获取配置创建的对象
        UserService userService = context.getBean("userService",UserService.class);

        userService.testService();
    }

    @Test
    public void testBean(){
        //记载spring的配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean3.xml");

        //获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);

        emp.test();
    }



}

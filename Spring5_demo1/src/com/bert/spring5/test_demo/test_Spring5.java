package com.bert.spring5.test_demo;

import com.bert.spring5.Book;
import com.bert.spring5.Orders;
import com.bert.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;

public class test_Spring5 {

    @Test
    public void testAdd(){
        //记载spring的配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        //获取配置创建的对象
        User user = context.getBean("user",User.class);

        System.out.println(user);
        user.add();
    }


    @Test
    public void testDemo() {
        //记载spring的配置文件
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");


        //获取配置创建的对象
        Book book = context.getBean("book", Book.class);

        System.out.println(book);
        book.testDemo();
    }

    @Test
    public void testOrders() {
        //记载spring的配置文件
        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean1.xml");


        //获取配置创建的对象
        Orders orders = context.getBean("orders", Orders.class);

        System.out.println(orders);
        orders.testOrders();
    }
}

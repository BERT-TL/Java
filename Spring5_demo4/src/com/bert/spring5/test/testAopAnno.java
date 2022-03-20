package com.bert.spring5.test;

import com.bert.spring5.AopAnno.User;
import com.bert.spring5.AopXml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAopAnno {

    @Test
    public void testAnno() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testXml() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}

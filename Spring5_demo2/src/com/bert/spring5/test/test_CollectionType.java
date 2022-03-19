package com.bert.spring5.test;

import com.bert.spring5.Bean.MyBean;
import com.bert.spring5.collectionType.Book;
import com.bert.spring5.collectionType.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class test_CollectionType {

    @Test
    public void test() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");

        Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }

    @Test
    public void test1() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean2.xml");

        Book book = context.getBean("book", Book.class);
        book.test();

    }

    @Test
    public void testBean() {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("bean3.xml");

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean3.xml");
//        第四步获取对象
        MyBean myBean= context.getBean("myBean", MyBean.class);
        System.out.println("第四步：获取对象");
        System.out.println(myBean);

//        第五步：配置销毁方法
        context.close();
    }


}

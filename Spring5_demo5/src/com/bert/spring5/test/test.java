package com.bert.spring5.test;

import com.bert.spring5.Service.BookService;
import com.bert.spring5.entity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class test {
    @Test
    public void testJdbcTemplate() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
//        //增加操作
//        book.setUserId("1");
//        book.setUsername("java");
//        book.setUstatus("Y");
//        bookService.addBook(book);

//        //修改操作
//        book.setUserId("1");
//        book.setUsername("Python");
//        book.setUstatus("N");
//        bookService.alterBook(book);

//        //删除操作
//        book.setUserId("1");
//        bookService.deleteBook(book);

//        //查询计数
//        int n = 0;
//        n = bookService.countBook();
//        System.out.println(n);

//        //返回一条信息
//        Book book1 = bookService.findOne("1");
//        System.out.println(book1);

//        //返回集合
//        List<Book> list = bookService.findAllBook();
//        System.out.println(list);

//        //批量添加
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"3","java","q"};
//        Object[] o2 = {"4","mysql","k"};
//        Object[] o3 = {"5","redis","a"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchAddBook(batchArgs);

//        //批量修改
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"Java","t","3"};
//        Object[] o2 = {"MySQL","g","4"};
//        Object[] o3 = {"Redis","v","5"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchUpdateBook(batchArgs);


        //批量删除
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"1"};
        Object[] o2 = {"2"};
        Object[] o3 = {"5"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDeleteBook(batchArgs);



    }
}

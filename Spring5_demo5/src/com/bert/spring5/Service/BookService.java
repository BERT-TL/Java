package com.bert.spring5.Service;

import com.bert.spring5.Dao.BookDao;
import com.bert.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    //添加操作
    public void addBook(Book book) {
        bookDao.add(book);
    }

    //修改操作
    public void alterBook(Book book) {
        bookDao.alter(book);
    }

    //删除操作
    public void deleteBook(Book book) {
        bookDao.delete(book);
    }

    //返回计数值
    public int countBook(){
        return bookDao.count();
    }

    //返回查询一条的记录
    public Book findOne(String id){
        return bookDao.findOne(id);
    }

    //返回集合
    public List<Book> findAllBook(){
        List<Book> list;
        list = bookDao.findAll();
        return list;
    }

    //批量添加
    public void batchAddBook(List<Object[]> batchArgs){
        bookDao.batchAdd(batchArgs);
    }

    //批量添加
    public void batchUpdateBook(List<Object[]> batchArgs){
        bookDao.batchUpdate(batchArgs);
    }

    //批量添加
    public void batchDeleteBook(List<Object[]> batchArgs){
        bookDao.batchDelete(batchArgs);
    }

}

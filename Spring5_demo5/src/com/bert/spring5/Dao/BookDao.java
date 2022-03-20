package com.bert.spring5.Dao;

import com.bert.spring5.entity.Book;

import java.util.List;

public interface BookDao {

    //增加操作
    public void add(Book book);

    //修改操作
    public void alter(Book book);

    //删除操作
    public void delete(Book book);

    //返回计数值
    public int count();

    //返回查询一条的记录
    public Book findOne(String id);

    //返回集合
    public List<Book> findAll();

    //批量添加
    public void batchAdd(List<Object[]> batchArgs);

    //批量修改
    public void batchUpdate(List<Object[]> batchArgs);

    //批量删除
    public void batchDelete(List<Object[]> batchArgs);
}

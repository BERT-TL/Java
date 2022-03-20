package com.bert.spring5.Dao;

import com.bert.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //增加操作
    @Override
    public void add(Book book) {
        String sql = "insert into t_book values(?,?,?);";
        Object[] args = {book.getUserId(),book.getUsername(),book.getUstatus()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    //修改操作
    @Override
    public void alter(Book book) {
        String sql = "update t_book set username=?, ustatus=? where userId=?;";
        Object[] args = {book.getUsername(),book.getUstatus(),book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);

    }

    //删除操作
    @Override
    public void delete(Book book) {
        String sql = "delete from t_book where userId=?;";
        int update = jdbcTemplate.update(sql, book.getUserId());
        System.out.println(update);
    }

    //返回计数值
    @Override
    public int count() {
        String sql = "SELECT COUNT(*) FROM t_book;";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;
    }

    //返回查询的一条记录
    @Override
    public Book findOne(String id) {
        String sql = "SELECT * FROM t_book WHERE userId=?;";
        Book book1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book1;
    }

    //返回集合
    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM t_book;";
        List<Book> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
        return query;
    }

    //批量添加
    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        String sql = "insert into t_book values(?,?,?);";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));

    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql = "update t_book set username=?, ustatus=? where userId=?;";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql = "delete from t_book where userId=?;";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}

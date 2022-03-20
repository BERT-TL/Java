package DAO;

import java.io.IOException;
import JavaBean.*;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addCart extends HttpServlet {
	Connection conn = null;
	public addCart() {
		conn = ConnectionPool.getConn();
	}
	
//	添加购物车数据行
	public void add(Cart_bean bean) throws Exception{
		PreparedStatement ps = null;
		String url = "INSERT INTO cart VALUES(?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(url);
		ps.setString(1, bean.getId());
		ps.setString(2, bean.getGoodsName());
		ps.setString(3, bean.getKind());
		ps.setString(4, bean.getName());
		ps.setString(5, bean.getPhone());
		ps.setString(6, bean.getPrice());
		ps.setString(7, bean.getNum());		
		ps.execute();	
	}
	
//	查询是否已经添加到购物车
	public Cart_bean find(String id, String name, String phone) throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		String url = "select * from cart where id='"+id+"' and goodsName='"+name+"' and phone='"+phone+"'";
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(url);
		Cart_bean bean = null;
		while(rs.next()){
			bean = new Cart_bean();
			bean.setId(rs.getString("id"));
			bean.setName(rs.getString("goodsName"));
			bean.setKind(rs.getString("kind"));
			bean.setName(rs.getString("name"));
			bean.setPhone(rs.getString("phone"));
			bean.setPrice(rs.getString("price"));
			bean.setNum(rs.getString("num"));			
		}
		return bean;	
	}
	
	
//	删除购物车指定数据行
	public void delete(String id, String phone, String name) throws Exception{
		
		Statement stmt = null;
		stmt = conn.createStatement();
		String url = "delete from cart where phone='"+phone+"'and goodsName like '%"+name+"%' and id="+id;
		stmt.executeUpdate(url);	
	}
	
//	删除购物车所有数据行
	public void delete_all(String id) throws Exception{
		
		Statement stmt = null;
		stmt = conn.createStatement();
		String url = "delete from cart where id="+id;
		stmt.executeUpdate(url);	
	}
	
//	查询购物车中的数据放入购物车页面
	public ArrayList<Cart_bean> select(String id) throws Exception{
		ArrayList<Cart_bean> list = new ArrayList<Cart_bean>();
		Statement stmt = null;
		ResultSet rs = null;
		String url = "select *from cart where id ="+id;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(url);
		while(rs.next()){
			Cart_bean bean = new Cart_bean();
			bean.setId(rs.getString("id"));
			bean.setGoodsName(rs.getString("goodsName"));
			bean.setKind(rs.getString("kind"));
			bean.setName(rs.getString("name"));
			bean.setPhone(rs.getString("phone"));
			bean.setPrice(rs.getString("price"));
			bean.setNum(rs.getString("num"));
			
			list.add(bean);
		}
		return list;
	}


}

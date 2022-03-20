package DAO;

import java.io.IOException;
import DAO.*;
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

public class My_goods_dao extends HttpServlet {
	Connection conn = null;
	public My_goods_dao() {
		conn = ConnectionPool.getConn();
	}

//	添加我发布的商品的数据行
	public void add(Mygoods_bean bean) throws Exception{
		PreparedStatement ps = null;
		String url = "INSERT INTO my_goods VALUES(?,?,?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(url);
		ps.setString(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getKind());
		ps.setString(4, bean.getDate());
		ps.setString(5, bean.getTime());
		ps.setString(6, bean.getPrice());
		ps.setString(7, bean.getNum());	
		ps.setString(8, bean.getLastdate());
		ps.setString(9, bean.getLasttime());
		ps.setString(10, bean.getExit());
		ps.execute();	
	}
	
	
	//查询出其发布的所有商品信息
	public ArrayList<Goods_bean> find(String id) throws Exception{	
		ArrayList<Goods_bean> list = new ArrayList<Goods_bean>();
		Statement stmt = null;
		ResultSet rs = null;
		String url = "select *from goods where id ="+id;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(url);
		while(rs.next()){
			Goods_bean bean = new Goods_bean();
			bean.setId(rs.getString("id"));
			bean.setName(rs.getString("name"));
			bean.setKind(rs.getString("kind"));
			bean.setDetail(rs.getString("detail"));
			bean.setPrice(rs.getString("price"));
			bean.setNum(rs.getString("num"));
			bean.setDate(rs.getString("date"));
			bean.setTime(rs.getString("time"));
			
			list.add(bean);
		}
			
		return list;
		
	}
	
	//查询出其发布的所有商品信息
	public Goods_bean find_yes(String id,String name) throws Exception{	
		Statement stmt = null;
		ResultSet rs = null;
		String url = "select *from goods where name='"+name+"' and id ='"+id+"' ORDER BY DATE DESC,TIME DESC";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(url);
		Goods_bean bean = null;
		while(rs.next()){
			bean = new Goods_bean();
			bean.setId(rs.getString("id"));
			bean.setName(rs.getString("name"));
			bean.setKind(rs.getString("kind"));
			bean.setDetail(rs.getString("detail"));
			bean.setPrice(rs.getString("price"));
			bean.setNum(rs.getString("num"));
			bean.setDate(rs.getString("date"));
			bean.setTime(rs.getString("time"));
		}
		return bean;	
	}
	
	//查询出其发布的已售，删除的商品信息
	public ArrayList<Mygoods_bean> find_exit(String id,String exit) throws Exception{	
		ArrayList<Mygoods_bean> list = new ArrayList<Mygoods_bean>();
		Statement stmt = null;
		ResultSet rs = null;
		String url = "select * from my_goods where isexit="+exit+" and id ="+id+" ORDER BY DATE DESC,TIME DESC";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(url);
		while(rs.next()){
			Mygoods_bean bean = new Mygoods_bean();
			bean.setId(rs.getString("id"));
			bean.setName(rs.getString("name"));
			bean.setKind(rs.getString("kind"));
			bean.setDate(rs.getString("date"));
			bean.setTime(rs.getString("time"));	
			bean.setPrice(rs.getString("price"));
			bean.setNum(rs.getString("num"));
			bean.setLastdate(rs.getString("lastdate"));
			bean.setLasttime(rs.getString("lasttime"));	
			list.add(bean);
		}
		return list;	
	}
	

}

package DAO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.io.PrintWriter;
import DAO.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBean.*;


public class Goods_dao {
	Connection conn = null;
	public Goods_dao(){
		conn = ConnectionPool.getConn();
	}
	
//	1. data页面显示数据功能
	
//	查询所有数据行数
	public int getRow() throws Exception{
		Statement stmt = null;
		ResultSet rs = null;
		int lastRow = 0;//记录数据库的最后一行
		String url = "select * from goods";
		
		if(conn != null){
			stmt = conn.createStatement();
			rs = stmt.executeQuery(url);
			rs.last();
			lastRow = rs.getRow();//记录数据库最后一行
				
			}
			return lastRow;
	}
	

//	一次性查询10行数据
	public ArrayList<Goods_bean> findSome(String pages,int pageSize) throws Exception{
		ArrayList<Goods_bean> list = new ArrayList<Goods_bean>();
		Statement stmt = null;
		ResultSet rs = null;
		int pagesNow = 0;
		try { 
			pagesNow = (pages == null||pages=="") ? 1 : Integer.parseInt(pages); 
		} catch(Exception e) { }
		int startLine = (pagesNow-1)*10;//指定数据库从哪一行开始读取
		String url = "SELECT * FROM goods ORDER BY DATE DESC,TIME DESC LIMIT "+startLine+","+pageSize;//对数据库进行伪分页读取，一次只能读10行  
		
		if(conn != null){
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
			}			
			return list;
	}
	 
//	2. 我要发布商品信息功能
	
//	添加发布信息
	public void addGoods(Goods_bean bean) throws Exception{
		PreparedStatement ps = null;
		String url = "INSERT INTO goods VALUES(?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(url);
		ps.setString(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getKind());
		ps.setString(4, bean.getDetail());
		ps.setString(5, bean.getPrice());
		ps.setString(6, bean.getNum());
		ps.setString(7, bean.getDate());
		ps.setString(8, bean.getTime());
		ps.execute();	
		
	}
			
//	查找是否存在已发布同样的信息,查询数据
	public Goods_bean find(String id, String name) throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		String url = "select * from goods where id='"+id+"' and name='"+name+"'";
		
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
	
	//四大类的分别查找
	public ArrayList<Goods_bean> selectBy_kind(String pages,int pageSize,String kind) throws Exception{
		ArrayList<Goods_bean> list = new ArrayList<Goods_bean>();
		Statement stmt = null;
		ResultSet rs = null;
		int pagesNo = 0;
		try { 
			pagesNo = (pages == null||pages=="") ? 1 : Integer.parseInt(pages); 
		} catch(Exception e) { }
		int startLine = (pagesNo-1)*10;//指定数据库从哪一行开始读取
		String url = "SELECT * FROM goods where kind='"+kind+"' ORDER BY DATE DESC,TIME DESC LIMIT "+startLine+","+pageSize;//对数据库进行伪分页读取，一次只能读10行  
		
		if(conn != null){
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
			}
			
			return list;
	}
	 
	//查询各个种类的所有数据行数
	public int getRowBy_kind(String kind) throws Exception{
		Statement stmt = null;
		ResultSet rs = null;
		int lastRow = 0;//记录数据库的最后一行
		String url = "select * from goods where kind='"+kind+"'";
		
		if(conn != null){
			stmt = conn.createStatement();
			rs = stmt.executeQuery(url);
			rs.last();
			lastRow = rs.getRow();//记录数据库最后一行
				
			}
			return lastRow;
	}
	
	//细分类的分别查找
	public ArrayList<Goods_bean> selectBy_detail(String pages,int pageSize,String detail) throws Exception{
		ArrayList<Goods_bean> list = new ArrayList<Goods_bean>();
		Statement stmt = null;
		ResultSet rs = null;
		int pagesNo = 0;
		try { 
			pagesNo = (pages == null||pages=="") ? 1 : Integer.parseInt(pages); 
		} catch(Exception e) { }
		int startLine = (pagesNo-1)*10;//指定数据库从哪一行开始读取
		String url = "SELECT * FROM goods where detail='"+detail+"' ORDER BY DATE DESC,TIME DESC LIMIT "+startLine+","+pageSize;//对数据库进行伪分页读取，一次只能读10行  
		
		if(conn != null){
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
			}
			
			return list;
	}
	 
	//查询各个细分种类的所有数据行数
	public int getRowBy_detail(String detail) throws Exception{
		Statement stmt = null;
		ResultSet rs = null;
		int lastRow = 0;//记录数据库的最后一行
		String url = "select * from goods where detail='"+detail+"'";
		
		if(conn != null){
			stmt = conn.createStatement();
			rs = stmt.executeQuery(url);
			rs.last();
			lastRow = rs.getRow();//记录数据库最后一行
				
			}
			return lastRow;
	}
	
	
	//商品名称搜索
	public ArrayList<Goods_bean> search(String name, String pages,int pageSize) throws Exception{
		ArrayList<Goods_bean> list = new ArrayList<Goods_bean>();
		Statement stmt = null;
		ResultSet rs = null;
		int pagesNow = 0;
		try { 
			pagesNow = (pages == null||pages=="") ? 1 : Integer.parseInt(pages); 
		} catch(Exception e) { }
		int startLine = (pagesNow-1)*10;//指定数据库从哪一行开始读取
		String url = "SELECT * FROM goods where name like '%"+name+"%'  ORDER BY DATE DESC,TIME DESC LIMIT "+startLine+","+pageSize;
		
		if(conn != null){
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
			}
			return list;
	}

//	搜索的数据行
	public int getRowBy_name(String name) throws Exception{
		Statement stmt = null;
		ResultSet rs = null;
		int lastRow = 0;//记录数据库的最后一行
		String url = "select * from goods where name like '%"+name+"%'";
		
		if(conn != null){
			stmt = conn.createStatement();
			rs = stmt.executeQuery(url);
			rs.last();
			lastRow = rs.getRow();//记录数据库最后一行
				
			}
			return lastRow;
	}


}

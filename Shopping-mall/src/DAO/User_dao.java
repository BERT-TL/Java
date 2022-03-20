package DAO;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import JavaBean.*;
import DAO.*;

public class User_dao{
	Connection conn = null;
	public User_dao(){
		conn = ConnectionPool.getConn();
	}
	
	 
	//添加
	public void AddUser(User_bean user) throws Exception{
		PreparedStatement ps = null;
		String url = "INSERT INTO USER VALUES(?,?,?,?,?,?)";
		ps = conn.prepareStatement(url);
		ps.setString(1, user.getId());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getName());
		ps.setString(4, user.getPhone());
		ps.setString(5, user.getInstitute());
		ps.setString(6, user.getE_mail());
		ps.execute();	
	}
		
	//查找是否存在用户和id查找值的功能
	public User_bean find(String id) throws Exception{
		Statement stmt = null;
		ResultSet rs = null;
		String url = "select * from user where id=" +id;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(url);
		User_bean user = null;
		while(rs.next()){
			user = new User_bean();
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setPhone(rs.getString("phone"));
			user.setInstitute(rs.getString("institute"));
			user.setE_mail(rs.getString("e_mail"));
		}
		return user; 
	} 
		
	//登录验证
	public User_bean login(String id, String password) throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		String url = "select * from user where id='"+id+"' and password=" +password;
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(url);
		User_bean user = null;
		while(rs.next()){
			user = new User_bean();
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setPhone(rs.getString("phone"));
			user.setInstitute(rs.getString("institute"));
			user.setE_mail(rs.getString("e_mail"));
			
//			System.out.println(id);
		}
		return user;		
	}
	
	//修改个人信息
	public void alter_personal(User_bean bean) throws Exception{
		PreparedStatement ps = null;
		String url = "update user set name=?, phone=?, institute=?, e_mail=? where id=?";
		ps = conn.prepareStatement(url);
		ps.setString(1, bean.getName());
		ps.setString(2, bean.getPhone());
		ps.setString(3, bean.getInstitute());
		ps.setString(4, bean.getE_mail());
		ps.setString(5, bean.getId());
		ps.executeUpdate();
		System.out.println(bean.getId());
		
		ps.close();
	}
	//修改密码
	public void alter_password(User_bean bean) throws Exception{
		PreparedStatement ps = null;
		String url = "update user set password=? where id=?";
		ps = conn.prepareStatement(url);
		ps.setString(1, bean.getPassword());
		ps.setString(2, bean.getId());
		ps.executeUpdate();
		
		ps.close();
	}

}
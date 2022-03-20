package DAO;

import java.sql.Connection;
import javax.servlet.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPool {
	public static Connection getConn() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost/shopping_mall";
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 1.加载驱动
			conn = DriverManager.getConnection(url, "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (conn == null)
			System.out.println("连接数据库失败");
		else
			System.out.println("连接数据库成功");
		return conn;
	}

	public static void close(Statement stmt, Connection conn) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt, ResultSet rs, Connection conn) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

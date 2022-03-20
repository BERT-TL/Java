package Servlet;

import java.io.IOException;
import DAO.*;
import JavaBean.*;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delete_cart extends HttpServlet {

	public delete_cart() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		User_bean bean = (User_bean)request.getSession().getAttribute("user");//获取当前登录用户的账号
		String op = request.getParameter("op");
//		把添加的商品从购物车里移除
		if(op.equals("delete")){
			addCart dao = new addCart();
			String phone = request.getParameter("phone");
			String name = request.getParameter("name");
			System.out.println("phone"+phone);
			try{
				dao.delete(bean.getId(),phone,name);	
				System.out.println("删除");
				out.print("<script type='text/javascript'>window.location.href='Add_cart?op=cart';alert('成功从购物车中删除  !');</script>");
//				request.getRequestDispatcher("Add_cart?op=cart").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		if(op.equals("all")){
			addCart dao = new addCart();
//			String phone = request.getParameter("phone");
//			String name = request.getParameter("name");
//			System.out.println("phone"+phone);
			try{
				dao.delete_all(bean.getId());	
//				System.out.println("删除");
				out.print("<script type='text/javascript'>window.location.href='Add_cart?op=cart';alert('购物车中商品已全部删除 !');</script>");
//				request.getRequestDispatcher("Add_cart?op=cart").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

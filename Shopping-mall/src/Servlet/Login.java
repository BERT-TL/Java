package Servlet;

import java.io.IOException;
import DAO.*;
import JavaBean.*;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	
	public Login() {
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

		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
//		System.out.println(id);
		
		User_dao dao = new User_dao();
		try{
			User_bean user = dao.login(id, password);
			if(user!=null){
//				System.out.println("登录成功！");
	        	request.getSession().setAttribute("user", user); //用session保存用户信息
	        	request.getRequestDispatcher("frame.jsp").forward(request, response);
//	        	System.out.println(request.getSession().getAttribute(user.getId()));

			}else{
//				System.out.println("登录失败！");
				request.setAttribute("message", "用户名或密码错误!");
//				request.getSession().setAttribute("message", "用户名或密码错误！");
//				response.sendRedirect("Login.jsp");
				//response.getWriter().write("<script language='javascript'>alert('用户名或密码不正确！')</script>");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

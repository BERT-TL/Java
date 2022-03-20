package Servlet;

import java.io.IOException;
import JavaBean.*;
import DAO.*;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	public Register (){
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if((request.getParameter("id")!= null)&&(request.getParameter("id1")==null||request.getParameter("id1")=="")){
			 String id = request.getParameter("id");
			 String password = request.getParameter("password");
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				String institute = request.getParameter("institute");
				String e_mail = request.getParameter("e_mail");
				
				System.out.println(id);
				
				User_bean user = new User_bean();
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setPhone(phone);
				user.setInstitute(institute);
				user.setE_mail(e_mail);
				
				User_dao dao = new User_dao();
				try{
					User_bean bean = dao.find(id);
					if(bean != null){
						request.setAttribute("register", "该用户已存在!");		
						System.out.println("用户已存在！");
						request.getRequestDispatcher("register.jsp").forward(request, response);
//						out.print("<script type='text/javascript'>alert('注册成功!');window.location.href='Login.jsp';</script>");
					}else{	
//						System.out.println("注册成功！");
						dao.AddUser(user);
						request.getSession().removeAttribute("register");
//						out.print("<script type='text/javascript'>alert('注册成功！   请登录')</script>");
						out.print("<script type='text/javascript'>alert('注册成功!');window.location.href='Login.jsp';</script>");
//						request.getRequestDispatcher("Login.jsp").forward(request, response);
					}
				}catch(Exception e){
					e.printStackTrace();
				}	
			 
		}else{
			String id = request.getParameter("id1");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String institute = request.getParameter("institute");
			String e_mail = request.getParameter("e_mail");
			
			System.out.println(id);
			
			User_bean user = new User_bean();
			user.setId(id);
			user.setPassword(password);
			user.setName(name);
			user.setPhone(phone);
			user.setInstitute(institute);
			user.setE_mail(e_mail);
			
			User_dao dao = new User_dao();
			try{
				User_bean bean = dao.find(id);
				if(bean != null){
					request.setAttribute("register", "该用户已存在!");		
					System.out.println("用户已存在在！");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}else{	
					System.out.println("注册成功！");
					dao.AddUser(user);
					request.getSession().removeAttribute("register");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
					
	}
		
	public void init() throws ServletException {
	}

}

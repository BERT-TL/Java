package Servlet;

import java.io.IOException;
import DAO.*;
import JavaBean.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class alter_personal extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public alter_personal() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String institute = request.getParameter("institute");
		String e_mail = request.getParameter("e_mail");
		
		System.out.println(id);
		
		User_bean bean = new User_bean();
		bean.setId(id);
		bean.setName(name);
		bean.setPhone(phone);
		bean.setInstitute(institute);
		bean.setE_mail(e_mail);
		
		System.out.println(bean.getName());
		User_dao dao = new User_dao();
		try{
			dao.alter_personal(bean);
			out.print("<script type='text/javascript'>alert('修改个人信息成功!');window.location.href='frame.jsp';</script>");
//			request.getRequestDispatcher("frame.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
		
		
		

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

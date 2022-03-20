package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.User_dao;
import JavaBean.User_bean;

public class alter_password extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public alter_password() {
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
		String op = request.getParameter("op");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if(password!=null){
			User_bean bean = new User_bean();
			bean.setId(id);
			bean.setPassword(password);
			
//			System.out.println(bean.getId());
//			System.out.println(bean.getPassword());
			User_dao dao = new User_dao();
			try{
				dao.alter_password(bean);
				if(op.equals("frame")){
					request.getSession().removeAttribute("user");
					out.print("<script type='text/javascript'>alert('修改密码成功,请重新登录!');window.location.href='Login_frame.jsp';</script>");
				}else{
					out.print("<script type='text/javascript'>alert('修改密码成功!');window.location.href='Login.jsp';</script>");
				}
				
				
//				request.getRequestDispatcher("frame.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			out.flush();
			out.close();
			
		}
		
		

		
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

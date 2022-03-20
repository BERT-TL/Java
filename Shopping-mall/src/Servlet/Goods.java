package Servlet;

import java.io.IOException;
import DAO.*;
import JavaBean.*;
import java.io.PrintWriter;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Goods extends HttpServlet {


	public Goods() {
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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String op = request.getParameter("op");
		System.out.println(op);
		
		//发布商品--插入数据
		if(op.equals("insert")){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String kind = request.getParameter("kind");
			String detail = request.getParameter("detail");
			String price = request.getParameter("price");
			String num = request.getParameter("num");
			//获取发布时间，日期
			SimpleDateFormat formatter_date = new SimpleDateFormat("yyyy-MM-dd");
		   	SimpleDateFormat formatter_hours = new SimpleDateFormat("HH:mm:ss");
			java.util.Date currentTime = new java.util.Date();//得到当前系统时间
			String date = formatter_date.format(currentTime); //将日期时间格式化
			String time = formatter_hours.format(currentTime); //将日期时间格式化
	
			Goods_bean bean = new Goods_bean();
			bean.setId(id);
			bean.setName(name);
			bean.setKind(kind);
			bean.setDetail(detail);
			bean.setPrice(price);
			bean.setNum(num);
			bean.setDate(date);
			bean.setTime(time);
			
			Goods_dao dao = new Goods_dao();
			try{
				Goods_bean goods = dao.find(id,name);
				if(goods != null){
					request.getSession().setAttribute("message_goods","该商品您已经发布");
					request.getRequestDispatcher("goods.jsp").forward(request, response);
				}else{
					dao.addGoods(bean);
					out.print("<script type='text/javascript'>alert('发布商品成功!');window.location.href='data.jsp';</script>");
//					request.getRequestDispatcher("frame.jsp").forward(request, response);
				}	
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
		//商品的换页
//		String op = request.getParameter("op");
		String sort = request.getParameter("sort");		
		String kind = request.getParameter("kind");
		request.getSession().setAttribute("kind", kind);
		String detail = request.getParameter("detail");	
		request.getSession().setAttribute("detail", detail);
		
		System.out.println("1"+kind);
		System.out.println("2"+detail);
		
		//上一页，下一页
		if(op.equals("jump")){
			int pagesNow = Integer.parseInt(request.getParameter("pagesNow"));
			int pagesCount = Integer.parseInt(request.getParameter("pagesCount"));
			String handle = request.getParameter("handle");
			
			
			if(handle.equals("pre")){
				int prePage;//上一页的页数
				if(pagesNow == 1){
					prePage = 1;//若当前页是第一页，则第一页只能是当前页
				}else{
					prePage = pagesNow - 1;//除了上述情况外上一页等于当前页-1页
				}
				request.getRequestDispatcher("data.jsp?pages="+prePage).forward(request, response);
				
				
			}else{
				int nextPage;
				if(pagesNow == pagesCount){//下一页的原理和上一页同理
					nextPage = pagesCount;
				}else{
					nextPage = pagesNow + 1;
				}	
				request.getRequestDispatcher("data.jsp?pages="+nextPage).forward(request, response);
		
			}
		}
		
		if(op.equals("click")){
			int pages = Integer.parseInt(request.getParameter("pages"));
//			String sort = request.getParameter("sort");
			request.getRequestDispatcher("data.jsp?pages="+pages).forward(request, response);
		 }		
	}

	
	public void init() throws ServletException {
		
	}

}

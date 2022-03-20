package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import JavaBean.*;

public class Mygoods extends HttpServlet {

	public Mygoods() {
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
		
		//获取发布时间，日期
		SimpleDateFormat formatter_date = new SimpleDateFormat("yyyy-MM-dd");
	   	SimpleDateFormat formatter_hours = new SimpleDateFormat("HH:mm:ss");
		java.util.Date currentTime = new java.util.Date();//得到当前系统时间
		String lastdate = formatter_date.format(currentTime); //将日期时间格式化
		String lasttime = formatter_hours.format(currentTime); //将日期时间格式化
		
		User_bean bean = (User_bean)request.getSession().getAttribute("user");//获取当前登录用户的账号
		String op = request.getParameter("op");
		
		My_goods_dao dao = new My_goods_dao();
		
//		展示我发布的所有商品
		if(op.equals("show")){
			try{
				ArrayList<Goods_bean> goodslist = (ArrayList<Goods_bean>)dao.find(bean.getId());
				request.getSession().setAttribute("goodslist", goodslist);
				request.getRequestDispatcher("order_all.jsp").forward(request, response);
				
			}catch(Exception e){
				e.printStackTrace();
			}	
		}
		
//		把我的商品发布数据存储到mygoods表中
//		点击为已售
		if(op.equals("yes")){		
			String name = request.getParameter("name");
			System.out.println("yes:"+name);
			
			String yes = "1";
			try{
				ArrayList<Mygoods_bean> mygoodslist = new ArrayList<Mygoods_bean>();
				Mygoods_bean mygoods = new Mygoods_bean();
				Goods_bean goods = (Goods_bean)dao.find_yes(bean.getId(),name);
//				Iterator<Goods_bean> it = goodslist.iterator();
				
//				Goods_bean goods = (Goods_bean)it.next();
				mygoods.setId(goods.getId());
				mygoods.setName(goods.getName());
				mygoods.setKind(goods.getKind());
				mygoods.setDate(goods.getDate());
				mygoods.setTime(goods.getTime());
				mygoods.setPrice(goods.getPrice());
				mygoods.setNum(goods.getNum());
				mygoods.setLastdate(lastdate);
				mygoods.setLasttime(lasttime);
				mygoods.setExit(yes);
				mygoodslist.add(mygoods);
				
				My_goods_dao mydao = new My_goods_dao();
				mydao.add(mygoods);
				out.print("<script type='text/javascript'>window.location.href='order_all.jsp';alert('恭喜您成功售卖该商品!');</script>");
					
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
//		点击为删除该订单
		if(op.equals("no")){
			String name = request.getParameter("name");
			System.out.println("no:"+name);
			String no = "0";
			try{
				Mygoods_bean mygoods = new Mygoods_bean();
				Goods_bean goods = (Goods_bean)dao.find_yes(bean.getId(),name);

				mygoods.setId(goods.getId());
				System.out.println(goods.getId());
				mygoods.setName(goods.getName());
				mygoods.setKind(goods.getKind());
				mygoods.setDate(goods.getDate());
				mygoods.setTime(goods.getTime());
				mygoods.setPrice(goods.getPrice());
				mygoods.setNum(goods.getNum());
				mygoods.setLastdate(lastdate);
				mygoods.setLasttime(lasttime);
				mygoods.setExit(no);
				
				My_goods_dao mydao = new My_goods_dao();
				mydao.add(mygoods);
				out.print("<script type='text/javascript'>window.location.href='order_all.jsp';alert('您成功删除该发布的商品!');</script>");
					
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
//		查看以售卖的商品
		if(op.equals("select_sale")){
			String  exit = "1";
			My_goods_dao mygoods_dao = new My_goods_dao(); 
			try{
				ArrayList<Mygoods_bean> list = (ArrayList<Mygoods_bean>)mygoods_dao.find_exit(bean.getId(), exit);
				request.getSession().setAttribute("list", list);
				request.getRequestDispatcher("order_sold.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}		
		}
		
//		查看以删除的商品
		if(op.equals("select_del")){
			String  exit = "0";
			My_goods_dao mygoods_dao = new My_goods_dao(); 
			try{
				ArrayList<Mygoods_bean> list = (ArrayList<Mygoods_bean>)mygoods_dao.find_exit(bean.getId(),exit);
				System.out.println("mygoods:"+list.size());
				request.getSession().setAttribute("list", list);
				request.getRequestDispatcher("order_delete.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

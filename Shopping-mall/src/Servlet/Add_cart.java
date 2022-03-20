package Servlet;

import java.io.IOException;
import DAO.*;
import JavaBean.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add_cart extends HttpServlet {

	
	public Add_cart() {
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
		String op = request.getParameter("op");
		System.out.println("op="+op);
		
		User_bean bean = (User_bean)request.getSession().getAttribute("user");//获取当前登录用户的账号
		addCart addcart = new addCart();
		
//		把数据添加到购物车页面当中去
		
		if(op.equals("cart")){
					
			try{
				ArrayList<Cart_bean> list = addcart.select(bean.getId());
				Iterator<Cart_bean> it = list.iterator();
				request.getSession().setAttribute("list", list);
				while(it.hasNext()){
					request.getSession().removeAttribute("cart");
					request.getRequestDispatcher("cart.jsp").forward(request, response);
				}
				request.getSession().setAttribute("cart", "目前还没有添加任何商品哦，赶紧去添加哦！");
				request.getRequestDispatcher("cart.jsp").forward(request, response);
						
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
//		添加数据到Cart_bean		
		if(op.equals("add")){
			String sales_id = request.getParameter("sales_id");  //获取这条信息发布者的账号
			String name = request.getParameter("name");
			String from = request.getParameter("from");
			String kind = request.getParameter("kind");
			String detail = request.getParameter("detail");
//			User_bean bean = (User_bean)request.getSession().getAttribute("user");//获取当前登录用户的账号
			request.getSession().setAttribute("kind", kind);
			request.getSession().setAttribute("detail", detail);
			System.out.println("sort:"+kind);
			System.out.println("detail:"+detail);
			System.out.println("from:"+from);

			User_dao user_dao = new User_dao();
			Goods_dao goods_dao = new Goods_dao();
			try{
				User_bean user = user_dao.find(sales_id);
				Goods_bean goods = goods_dao.find(sales_id, name); 
//				request.getSession().setAttribute("user", user);
//				request.getSession().setAttribute("goods", goods);
			
				Cart_bean cart = new Cart_bean(); 	//把获取的数据保存到购物车bean(Cart_bean)中
				cart.setId(bean.getId());			//从session中 获取当前登录用户的账号名
				cart.setGoodsName(goods.getName());	//从商品表goods中获取商品名称
				cart.setKind(goods.getKind());		//从goods中获取商品种类
				cart.setName(user.getName());		//从用户表中获取用户姓名
				cart.setPhone(user.getPhone());		//从user表中获取用户联系电话
				cart.setPrice(goods.getPrice());	//从goods表获取商品的价格
				cart.setNum(goods.getNum());		//从goods表中获取商品的数量
			
//				addCart addcart = new addCart();
				Cart_bean cart_bean = addcart.find(bean.getId(), goods.getName(),user.getPhone());
												//判断其购物车中是否已经存在该商品
				if(cart_bean!=null){				
					out.print("<script type='text/javascript'>window.location.href='"+from+"?kind="+kind+"&detail="+detail+"';alert('您购物车中已存在，不能再次添加!');</script>");
				}else{
					addcart.add(cart);				//把存储到Cart_bean中的数据存储到购物车表(cart)中
					out.print("<script type='text/javascript'>window.location.href='"+from+"?kind="+kind+"&detail="+detail+"';alert('成功添加到购物车!');</script>");
				}
								
			
//				request.getRequestDispatcher("data.jsp").forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
			
	}


	public void init() throws ServletException {
		// Put your code here
	}

}

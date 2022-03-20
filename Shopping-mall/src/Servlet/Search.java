package Servlet;

import java.io.IOException;
import DAO.*;
import JavaBean.*;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends HttpServlet {

	public Search() {
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

		
		
		
		String name = request.getParameter("search");
		request.getSession().setAttribute("name", name);
		System.out.println("搜索："+name);
		
		Goods_dao dao = new Goods_dao();
		
		try{
			int lastRow = dao.getRowBy_name(name);//获取总数据行
			request.getSession().setAttribute("lastRow", lastRow);
			System.out.println("行："+lastRow);

			String pages = request.getParameter("pages");//获取当前页数
			//System.out.println(pages);
			int pagesNow = 0;//当前页面
			try { 
				pagesNow = (pages == null||pages=="") ? 1 : Integer.parseInt(pages); 
			}catch(Exception e){ }
		
			int pagesCount = 0;//用于数据库最后读出所有行后，总共有多少页
			int pageSize = 10;//指定数据库一次读取多少行
			pagesCount = (lastRow % pageSize == 0) ? (lastRow / pageSize) : (lastRow / pageSize +1);//计算数据库能读出来的全部页数
			System.out.println(pagesCount);
			int minpages = (pagesNow - 3 >0) ? (pagesNow - 3) : 1;//设定最小页，防止页数小于第一页
			int maxpages = (pagesNow + 3 >= pagesCount) ? (pagesCount) : (pagesNow+3);//设定最大页
			
			//System.out.println("小"+minpages);
		
			request.getSession().setAttribute("pagesNow",pagesNow);
			request.getSession().setAttribute("minpages",minpages);
			request.getSession().setAttribute("maxpages",maxpages);

			//System.out.println("ser行数："+lastRow);
			
			ArrayList<Goods_bean> Goodslist = dao.search(name,pages,pageSize);
			
//			ArrayList<User_bean> Userlist = dao.searchBy_user(name,pages,pageSize);
			System.out.println("Goods:"+Goodslist.size()); 
//			System.out.println("User:"+Userlist.size());
			System.out.println("qq");
			Iterator<Goods_bean> it = Goodslist.iterator();
			request.getSession().setAttribute("Goodslist", Goodslist);
			while(it.hasNext()){
				request.getSession().removeAttribute("search");
				request.getRequestDispatcher("search.jsp").forward(request, response);
				
			}
			System.out.println("没有");
			request.getSession().setAttribute("search", "没用您所要找的物品！");
			request.getRequestDispatcher("search.jsp").forward(request, response);
			
			
			
			
			//上下页
			String op = request.getParameter("op");
			if(op.equals("jump")){
			
				String handle = request.getParameter("handle");

				if(handle.equals("pre")){
					int prePage;//上一页的页数
					if(pagesNow == 1){
						prePage = 1;//若当前页是第一页，则第一页只能是当前页
					}else{
						prePage = pagesNow - 1;//除了上述情况外上一页等于当前页-1页
					}
					request.getRequestDispatcher("search.jsp?pages="+prePage).forward(request, response);
					
				}else{
					int nextPage;
					if(pagesNow == pagesCount){//下一页的原理和上一页同理
						nextPage = pagesCount;
					}else{
						nextPage = pagesNow + 1;
					}
					request.getRequestDispatcher("search.jsp?pages"+nextPage).forward(request, response);
					
				}
			}
			
			if(op.equals("click")){
				
				request.getRequestDispatcher("search.jsp").forward(request, response);
			
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}		
	}


	public void init() throws ServletException {
		// Put your code here
	}

}

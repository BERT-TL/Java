package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sort extends HttpServlet {

	
	public Sort() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
//		PrintWriter out = response.getWriter();
		String op = request.getParameter("op");
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
				if(sort.equals("kind")){
					request.getRequestDispatcher("kind.jsp?pages="+prePage).forward(request, response);
				}else{
					request.getRequestDispatcher("detail_data.jsp?pages="+prePage).forward(request, response);
				}	
				
			}else{
				int nextPage;
				if(pagesNow == pagesCount){//下一页的原理和上一页同理
					nextPage = pagesCount;
				}else{
					nextPage = pagesNow + 1;
				}	
				if(sort.equals("kind")){
					request.getRequestDispatcher("kind.jsp?pages="+nextPage).forward(request, response);
				}else{
					request.getRequestDispatcher("detail_data.jsp?pages="+nextPage).forward(request, response);
				}			
				
			}
		}
		
		if(op.equals("click")){
			int pages = Integer.parseInt(request.getParameter("pages"));
//			String sort = request.getParameter("sort");
			if(sort.equals("kind")){
				request.getRequestDispatcher("kind.jsp?pages="+pages).forward(request, response);
			}else{
				request.getRequestDispatcher("detail_data.jsp?pages="+pages).forward(request, response);
			}	
	
		}
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}

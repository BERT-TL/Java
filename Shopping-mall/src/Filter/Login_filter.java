package Filter;

import java.io.IOException;
import java.io.PrintWriter;
  
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
  
  
public class Login_filter implements Filter {
	public static final String login_page = "/Shopping-mall/Login_frame.jsp";
	public static final String logout_page = "/Shopping-mall/Login.jsp";
	
	public void destroy(){ 
	}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)throws ServletException, IOException {
	HttpServletRequest request = (HttpServletRequest)servletRequest;
 	HttpServletResponse response = (HttpServletResponse)servletResponse;
 	String currentURL = request.getRequestURI();
 	String ctxPath = request.getContextPath();
 //除掉项目名称时访问页面当前路径
 	String targetURL = currentURL.substring(ctxPath.length());  //目标地址
 	System.out.println(targetURL);
 	HttpSession session = request.getSession(false);
 //对当前页面进行判断，如果当前页面不为登录页面
 	if(!("/Shopping-mall/".equals(targetURL))){
 		System.out.println("1 "+targetURL+" ctxPath:"+ctxPath+" currentURL:"+currentURL);
 //在不为登陆页面时，再进行判断，如果不是登陆页面也没有session则跳转到登录页面，
 		if(session == null || session.getAttribute("user") == null){
 			response.sendRedirect(login_page);
 			System.out.println(login_page);
 			return;
 		}else{
 //这里表示正确，会去寻找下一个链，如果不存在，则进行正常的页面跳转
 			filterChain.doFilter(request, response);
 			System.out.println("哈哈");
 			return;
 		}
 	}else{
 //这里表示如果当前页面是登陆页面，跳转到登陆页面
 		filterChain.doFilter(request, response);
 		return;
 	}
 }
	
 	public void init(FilterConfig filterConfig)throws ServletException{
  
 	}
  
}



//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class Login_filter extends HttpServlet {
//
//	public void init(FilterConfig filterConfig) throws ServletException{
//		
//	}
//
//	private String login = "Login.jsp";
//	private String Login_frame = "Login_frame.jsp";
//	public void doFilter(ServletRequest request, ServletResponse response,
//			FilterChain chain) throws IOException, ServletException {
//		
//			HttpServletRequest hrequest = (HttpServletRequest) request;
//			String url = hrequest.getRequestURI();//得到请求地址
//			String file[] = url.split("/");//通过/分隔，这样，数组的最后一个值，就是页dao面，
//			//你比较下zhuanfile[file.lenght-1].equals("login.jsp")就可以了。
////			int length = ;
//			
//			
//			if(file[file.length-1].equals(("Login.jsp")||("Login_frame.jsp"))//{}要解除某页面的过滤，用||在if里面添加就可以
//			chain.doFilter(request, response);
//			}
//	
//	public void init() throws ServletException {
//		// Put your code here
//	}
//
//}

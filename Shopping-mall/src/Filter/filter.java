package Filter;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import javax.servlet.Filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class filter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException{
		
	}
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,ServletException{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		//拦截所有请求 解决全站中文编码
		//指定request response的编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//对request进行包装
		CharacterRequest characterRequest = new CharacterRequest(request);
		chain.doFilter(characterRequest, response);
		
		
	}
	public void destroy(){
		
	}
	
	//继承默认包装类HttpServletRequestWrapper
	class CharacterRequest extends HttpServletRequestWrapper{
		private HttpServletRequest request;
		
		public CharacterRequest(HttpServletRequest request){
			super(request);
			this.request = request;
		}
		
		//子类继承父类一定会覆写一些方法，此处用于重写getParameter()方法
		public String getParameter(String name){
			String value = super.getParameter(name);
			if(value == null){
				return null;	
			}
			//判断请求方式
			String method = super.getMethod();
			if(method.equalsIgnoreCase("get")){
				try{
					value = new String(value.getBytes("iso-8859-1"),"utf-8");				
				}catch(UnsupportedEncodingException e){
					throw new RuntimeException(e);
				}
			}
			return value;
			
			}
	}

	

}

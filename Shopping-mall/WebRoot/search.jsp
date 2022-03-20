<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="DAO.*,JavaBean.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>怪兽商城</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet"  type="text/css"  href="css/data.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/search.js"></script>
    <link rel="icon" href="favicon.ico">

  </head>
  
  <body>
  <%
  		
  		String pagesNow1 = request.getSession().getAttribute("pagesNow").toString(); 	 
  		int pagesNow = Integer.parseInt(pagesNow1);
  		System.out.println("page:"+pagesNow);
  		String name = request.getSession().getAttribute("name").toString(); 
  		System.out.println("11"+name);
  		String alert = (String)request.getSession().getAttribute("search");
  		System.out.println(alert);
 		
  		
   %>
  
    <div class="contain">
        <h2>您查找的信息</h2>
        <div class="prompt"><%=alert %></div>
        <table class="table">
            <thead>
                <tr>                    
                    <th>商品名称</th>
                    <th>种类</th>
                    <th>发布者</th>
                    <th>联系方式</th>
                    <th>发布日期</th>
                    <th>发布时间</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            <%
            String lastRow1 = request.getSession().getAttribute("lastRow").toString();
            int lastRow = Integer.parseInt(lastRow1);
  			System.out.println("Jsp行数："+lastRow);
  			
  			ArrayList<Goods_bean> Goodslist = (ArrayList<Goods_bean>)request.getSession().getAttribute("Goodslist");
  			//ArrayList<User_bean> Userlist = (ArrayList<User_bean>)request.getSession().getAttribute("Userlist");
  			//System.out.println("Jspuser:"+Userlist.size());
  				
                System.out.println(Goodslist.size());
                for(int i=0;i<Goodslist.size();i++){
                
                	Goods_bean bean = (Goods_bean)Goodslist.get(i);
                	//System.out.println("goods:"+goods.getId());
                	String id = bean.getId(); 
					System.out.println(id);
	            	User_dao user_dao = new User_dao();
	            	User_bean user = user_dao.find(id);
	            	
                	//User_bean user = (User_bean)request.getSession().getAttribute("User");
                	System.out.println("user:"+user.getName());
			 %>		
                <tr>
                    <td><%=bean.getName() %></td>
                    <td><%=bean.getKind() %></td>
                    <td><%=user.getName() %></td>
                    <td><%=user.getPhone() %></td>
                    <td><%=bean.getDate() %></td>
                    <td><%=bean.getTime() %></td>
                    <td><%=bean.getPrice() %></td>
                    <td><%=bean.getNum() %></td>
                    <td><a href="Add_cart?sales_id=<%=id %>&name=<%=bean.getName()%>&from=search.jsp">加购</a></td>
                </tr>
             <%} %>
            </tbody>
        </table>
        
        
        <div class="pageNav">
            <ul class="pagination">       
                <li class="page-item"><a class="page-link" href="Search?pages=<%=pagesNow%>&op=jump&handle=pre&search=<%=name %>">上一页</a></li>
                <%
					String strMin = request.getSession().getAttribute("minpages").toString();
					String strMax = request.getSession().getAttribute("maxpages").toString();				
					int minpages = Integer.parseInt(strMin);
					int maxpages = Integer.parseInt(strMax);
					System.out.println("大："+maxpages);
					for(int i = minpages;i <=maxpages ;i++){
						if(i == pagesNow){//当前页和遍历出来的页数相等时，需要通过调用css里面的样式“active"进行高亮
							out.print("<li class='page-item active'>");
							out.print("<a class='page-link active' href='Search?sort=All&search="+name+"&op=click&pages="+i+"'>"+i+"</a>");
							out.print("</li>");
						}else{//输出每一个分页
						out.print("<li class='page-item'>");
							out.print("<a class='page-link' href='Search?sort=All&search="+name+"&op=click&pages="+i+"'>"+i+"</a>");
						}	out.print("</li>");				
					}
					
			 	%>
                
                
                <li class="page-item"><a class="page-link" href="Search?pages=<%=pagesNow%>&sort=All&op=jump&handle=next&search=<%=name %>">下一页</a></li>
            </ul>
        </div>
        
    </div>
  </body>
</html>

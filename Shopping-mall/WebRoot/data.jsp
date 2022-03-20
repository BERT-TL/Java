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
    <link rel="icon" href="favicon.ico">

  </head>
  
  <body>
  <%
  		String pages = request.getParameter("pages");//获取当前页数
  		int pagesNow = 0;
		try { 
			pagesNow = (pages == null||pages=="") ? 1 : Integer.parseInt(pages); 
		} catch(Exception e) { }
		
  		int pagesCount = 0;//用于数据库最后读出所有行后总共有多少页
  		int pageSize = 10;//指定数据库一次读取多少行
  		
   %>
  
    <div class="contain">
        <h2>动态交易信息情况--全部</h2>
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
            String kind = request.getParameter("kind");
            //String kind = "电子产品";
  			Goods_dao dao = new Goods_dao();
  			int lastRow = dao.getRow();
  			//System.out.println(pages);
			//System.out.println("哈 "+kind);
			//System.out.println(pageSize);
			//System.out.println(lastRow);
  			ArrayList<Goods_bean> list = dao.findSome(pages,pageSize);	
  			Iterator<Goods_bean> it = list.iterator();
  	
			while(it.hasNext()){
				Goods_bean bean = (Goods_bean)it.next(); 
				
				String id = bean.getId(); 
                User_dao user_dao = new User_dao();
                User_bean user = user_dao.find(id);
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
                    <td><a href="Add_cart?sales_id=<%=id %>&name=<%=bean.getName()%>&from=data.jsp&op=add">加购</a></td>
                    
                </tr>
             <%} %>
            </tbody>
        </table>
        
        
        <div class="pageNav">
            <ul class="pagination">       
                <li class="page-item"><a class="page-link" href="Goods?pagesNow=<%=pagesNow%>&pagesCount=<%=pagesCount%>&op=jump&handle=pre&sort=kind&kind=<%=kind %>">上一页</a></li>
                <%
					pagesCount = (lastRow % pageSize == 0) ? (lastRow / pageSize) : (lastRow / pageSize +1);//计算数据库能读出来的全部页数
					System.out.println();
					System.out.println(pagesCount);
					int minpages = (pagesNow - 3 >0) ? (pagesNow - 3) : 1;//设定最小页，防止页数小于第一页
					int maxpages = (pagesNow + 3 >= pagesCount) ? (pagesCount) : (pagesNow+3);//设定最大页
					for(int i = minpages;i <=maxpages ;i++){
						if(i == pagesNow){//当前页和遍历出来的页数相等时，需要通过调用css里面的样式“active"进行高亮
							out.print("<li class='page-item active'>");
							out.print("<a class='page-link active' href='Goods?kind="+kind+"&op=click&sort=kind&pages="+i+"'>"+i+"</a>");
							out.print("</li>");
						}else{//输出每一个分页
						out.print("<li class='page-item'>");
							out.print("<a class='page-link' href='Goods?kind="+kind+"&op=click&sort=kind&pages="+i+"'>"+i+"</a>");
						}	out.print("</li>");				
					}
					
			 	%>
                
                
                <li class="page-item"><a class="page-link" href="Goods?pagesNow=<%=pagesNow%>&pagesCount=<%=pagesCount%>&op=jump&handle=next&sort=kind&kind=<%=kind %>">下一页</a></li>
            </ul>
        </div>
        
    </div>
  </body>
</html>

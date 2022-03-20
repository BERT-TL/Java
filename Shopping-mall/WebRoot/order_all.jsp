<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="DAO.*,JavaBean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN">
<html>
  <head>
    <title>怪兽商城</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet"  type="text/css"  href="css/order_all.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/order_all.js"></script>
    <link rel="icon" href="favicon.ico">

  </head>
  
  <body>
    <div class="contain">
        <h2>我发布的商品信息</h2>
        <table class="table">
            <thead>
                <tr>                    
                    <th>商品名称</th>
                    <th>种类</th>
                    <th>发布日期</th>
                    <th>发布时间</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
            <%
            	ArrayList<Goods_bean> list = (ArrayList<Goods_bean>)request.getSession().getAttribute("goodslist");
            	Iterator<Goods_bean> it = list.iterator();
            	while(it.hasNext()){
            		Goods_bean bean = (Goods_bean)it.next();
            	
             %>
                <tr>
                    <td class="name"><%=bean.getName() %></td>
                    <td><%=bean.getKind() %></td>
                    <td><%=bean.getDate() %></td>
                    <td><%=bean.getTime() %></td>
                    <td><%=bean.getPrice() %></td>
                    <td><%=bean.getNum() %></td>
                    <td>
                        <span class="doit">
                            <a href="Mygoods?op=yes&name=<%=bean.getName() %>" class="sale">已售</a>&nbsp;&nbsp;<a href="Mygoods?op=no&name=<%=bean.getName() %>" class="delete">删除</a>
                        </span>
                        <span class="nodo">
                            <span class="do_sale">已售</span><span class="do_delete">已删除</span></span>
                    </td>               
                </tr>
                <%} %>
            </tbody>
        </table>

        <div class="button">
            <a href="Mygoods?op=select_sale">查看已售商品</a>&nbsp;&nbsp;
            <a href="Mygoods?op=select_del">查看已删除商品</a>
        </div>
        
    </div>
    
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="DAO.*,JavaBean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>怪兽商城</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet"  type="text/css"  href="css/order_delete.css"/>
    <link rel="icon" href="favicon.ico">
</head>
<body>
    <div class="contain">
        <h2>我已售的商品信息</h2>
        <table class="table">
            <thead>
                <tr>                    
                    <th>商品名称</th>
                    <th>种类</th>
                    <th>发布日期</th>
                    <th>发布时间</th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>卖出日期</th>
                    <th>卖出时间</th>
                </tr>
            </thead>
            <tbody>
            <%
            	ArrayList<Mygoods_bean> list = (ArrayList<Mygoods_bean>)request.getSession().getAttribute("list");
            	Iterator<Mygoods_bean> it = list.iterator();
            	while(it.hasNext()){
            		Mygoods_bean bean = (Mygoods_bean)it.next();
             %>
                <tr>
                    <td><%=bean.getName() %></td>
                    <td><%=bean.getKind() %></td>
                    <td><%=bean.getDate() %></td>
                    <td><%=bean.getTime() %></td>
                    <td><%=bean.getPrice() %></td>
                    <td><%=bean.getNum() %></td>
                    <td><%=bean.getLastdate() %></td>
                    <td><%=bean.getLasttime() %></td>
                </tr>
                <%} %>
            </tbody>
        </table>
        <div class="button">
            <a href="Mygoods?op=show">返回所有商品信息</a>
            <a href="Mygoods?op=select_del">查看已删除商品</a>
        </div>
    </div>
    
</body>
</html>

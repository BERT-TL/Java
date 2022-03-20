<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN">
<html>
  <head>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>怪兽商城</title>
    <link rel="stylesheet" type="text/css" href="css/head.css">
    <link rel="icon" href="favicon.ico">
    <base target="_blank">

  </head>

  
  <body>
  
  
  
	<img src="images/bg.png">
    <div class="head">
        <div class="user">当前用户 :&nbsp;<span class="userName">${user.id }</span>&nbsp;&nbsp;</div>
        <div class="cart"><img src="images/car.png">&nbsp;<a href="Add_cart?op=cart">购物车</a></div>
        <!-- <div class="Login"><a href="Login.jsp">登录</a>&nbsp;|&nbsp;<a href="register.jsp">注册</a></div> -->
        <div><a href="word.jsp">留言板</a></div>
        <div class="exit"><a href="exit" target="_top">退出</a></div>
    </div>    


  </body>
</html>

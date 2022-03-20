<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	
    <link rel="stylesheet"  type="text/css"  href="css/Login.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/Login.js"></script>
    
	<link rel="shortcut icon" href="favicon.ico"/>
	

  </head>
  
  <body>
    <div class="main">
        <h2>欢迎登录怪兽--商城</h2>
        <div class="login">
        <div class="alert"><font color="red" size="2">${message}</font></div>
            <form action="Login" method="post">
            	
                <ul>
                    <li><input type="text" required="required" placeholder="学号/手机号" name="id" id="id"><span></span></li>
                    <li><input type="password" required="required" placeholder="请输入登录密码" name="password" id="password"><span></span></li>
                    <li class="inp"><input type="submit" value="登录"><input type="reset" value="重置"></li>
                    <li class="pw"><a href="Login_alterPassword.jsp" target="_top">忘记密码?</a><a href="register.jsp" target="_top">免费注册</a></li>
                </ul>
            </form>
            
        </div>
    </div>
    
  </body>
</html>

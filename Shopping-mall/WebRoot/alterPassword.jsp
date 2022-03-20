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
	
	<link rel="stylesheet"  type="text/css"  href="css/alterPassword.css"/>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/alter_password.js"></script>
    <link rel="icon" href="favicon.ico">

  </head>
  
  <body>
  
  <%  
  		String id = request.getParameter("id");  
  		if(id==null){ 
  			id=""; 
  		} 
		  
   %>
   
    <div class="main">
        <h2>修改用户密码</h2>
        <p class="alert">(注：下列信息中带“*”号的为必填内容)</p>
        <div class="login">
            <form action="alter_password?op=frame" onsubmit="return checkAll()" method="POST">
                <ul>
                    <li>
                        <div><span>* </span>用户名：</div>
                        <input type="text" placeholder="学号/手机号" readonly value="<%=id %>" name="id">               
                    </li>
                    <li>
                        <div><span>* </span>新密码：</div>
                        <input type="password" required="required" placeholder="请输入密码" onblur="checkPassword()" id="password" name="password">
                        <span id="passwordSpan"></span>
                    </li>
                    <li>
                        <div><span>* </span>确认密码：</div>
                        <input type="password" required="required" placeholder="请输入确定密码" onblur="checkSame()" id="password2">
                        <span id="passwordSpan2"></span>
                    </li>
                    <li class="inp">
                        <input type="submit" value="确定">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" id="reset">
                    </li>
                </ul>
            </form>
            
        </div>
    </div>
    
    
  </body>
</html>

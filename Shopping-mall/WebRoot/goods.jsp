<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.text.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<title>怪兽商城</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet"  type="text/css"  href="css/goods.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <link rel="icon" href="favicon.ico">

  </head>
  
  <body>
  
  <% 
  	String id = request.getParameter("id"); 
   %>
    
    <div class="main">
        <h2>商品发布</h2>
        <p class="alert">(注：下列信息中带“*”号的为必填内容)</p>
        <div class="register">
            <form action="Goods?id=<%=id %>&op=insert" method="POST">
                <ul>
                    <li>
                        <div><span>* </span>商品名称：</div>
                        <input type="text" required="required" onblur="checkName()" id="name" name="name">
                        <span id="nameSpan">${message_goods }</span>
                    </li>
                    <li>
                        <div><span>* </span>总的种类：</div>
                        <select name="kind" class="type_all" id="kind">
                            <option value="电子产品">电子产品</option>                         
                        </select>
                    </li>
                    <li><div><span>* </span>具体分类：</div>
                        <select name="detail" class="type_pri" id="detail">
                            <option value="手机">手机</option>                     
                        </select>
                    </li>
                    <li>
                        <div><span>* </span>单价：</div>
                        <input type="text" required="required" onblur="checkPrice()" id="price" name="price">
                        <span id="priceSpan"></span>
                    </li>
                    <li>
                        <div><span>* </span>数量：</div>
                        <input type="text" required="required" onblur="checkNum()" id="num" name="num">
                        <span id="numSpan"></span>
                    </li>   
                    <li class="inp">
                        <input type="submit" value="发布">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" id="reset">
                    </li>
                </ul>
            </form>
        </div>  
    </div>
    <script type="text/javascript" src="js/goods.js"></script>
  
  </body>
</html>

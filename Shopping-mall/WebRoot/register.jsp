<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>怪兽商城</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet"  type="text/css"  href="css/register.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
   <!--  <link rel="icon" href="favicon.ico"> --> 
    
  </head>
  
  <body>
    
        <div class="main">
            <div class="manner"><span class="id">学号注册</span><span class="phone">手机号注册</span></div>
            <h2>欢迎注册怪兽--商城</h2>
            <p class="alert">(注：下列信息中带“*”号的为必填内容)</p>
            <div class="register">
                <form method="post" action="Register" οnsubmit="return checkAll()">
                    <ul>
                        <li>
                            <div><span>* </span>昵称：</div>
                            <input type="text" required="required" onblur="checkName()" placeholder="请输入昵称" id="name" name="name">
                            <span id="nameSpan"></span>
                        </li>
                        <li class="phone_register">
                            <div><span>* </span>手机号：</div>
                            <input type="text" onblur="checkPhone()" placeholder="请输入手机号" id="phone" name="id1">
                            <span id="phoneSpan">${register}</span>
                        </li>
                        <li class="id_register">
                            <div><span>* </span>学号：</div>
                            <input type="text" onblur="checkId()" placeholder="请输入学号" id="id" name="id">
                            <span id="idSpan">${register}</span>
                        </li>                                              
                        <li>
                            <div><span>* </span>邮箱：</div>
                            <input type="email" onblur="checkEmail()" placeholder="请输入邮箱号" id="email" name="e_mail">
                            <span id="emailSpan"></span>
                        </li>
                        <li>
                            <div><span>* </span>密码：</div>
                            <input type="password" required="required" placeholder="请输入密码" onblur="checkPassword()" id="password" name="password">
                            <span id="passwordSpan"></span>
                        </li>
                        <li>
                            <div><span>* </span>确认密码：</div>
                            <input type="password" required="required" onblur="checkSame()" placeholder="请确认密码" id="password2" name="password2">
                            <span id="passwordSpan2"></span>
                        </li>
                        <!-- <li><div>出生日期：</div><input type="date"><span>哈哈哈</span></li> -->
                        <!-- <li class="sex"><div><span>* </span>性别：</div><input type="radio" name="sex" value="男" checked>&nbsp;男<input type="radio" name="sex" value="女">&nbsp;女</li> -->
                        <li>
                            <div><span>* </span>联系方式：</div>
                            <input type="text" required="required" placeholder="请输入联系方式" onblur="checkManner()" id="manner" name="phone">
                            <span id="mannerSpan"></span>
                        </li>
                        <li>
                            <div><span>* </span>学院：</div>
                            <select name="institute" class="institute">
                                <option value="计算机科学与工程学院">计算机科学与工程学院</option>
                                <option value="电子信息与工程学院">电子信息与工程学院</option>
                                <option value="国际商学院">国际商学院</option>
                                <option value="艺术学院">艺术学院</option>
                                <option value="管理学院">管理学院</option>
                            </select>
                        </li>
                        <li class="inp">
                            <p><input type="submit" value="注册"><input type="reset" value="重置" id="reset"></p>
                        </li>
                    </ul>
                </form>
            </div>  
        </div>
  </body>
</html>

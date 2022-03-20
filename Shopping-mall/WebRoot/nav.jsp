<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	
    <link rel="stylesheet"  type="text/css"  href="css/nav.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/nav.js"></script>
    <link rel="icon" href="favicon.ico">
    <base target="view_frame">

  </head>
  
  <body>
    <div class="nav">
        <div class="nav_head">
            <ul>
                <li class="item"><a href="data.jsp">首页</a></li>
                <li class="item"><a href="kind.jsp?kind=电子产品">电子产品</a></li>
                <li class="item"><a href="kind.jsp?kind=生活用品">生活用品</a></li>
                <li class="item"><a href="kind.jsp?kind=学习用品">学习用品</a></li>
                <li class="item"><a href="kind.jsp?kind=其他分类">其他分类</a></li>
            </ul>
             
        </div>
        <div class="nav_content">
            <div class="nav_content">
                <ul class="first_con">
                    <li><a href="detail_data.jsp?detail=手机">手机</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=电脑">电脑</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=相机">相机</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=衣服">衣服</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=数据">书籍</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=健身器材">健身器材</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=学习资料">学习资料</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=洗衣液">洗衣液</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=床上物品">床上物品</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=考研资料">考研资料</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=花卉">花卉</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=其他">其他</a></li><li> | </li>
                </ul>
    
                <ul class="Electronics_con">
                    <li><a href="detail_data.jsp?detail=手机">手机</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=电脑">电脑</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=相机">相机</a></li><li> | </li>
                </ul>
                <ul class="life_con">
                    <li><a href="detail_data.jsp?detail=洗衣液">洗衣液</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=衣服">衣服</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=床单">床单</a></li><li> | </li>
                </ul>
    
                <ul class="study_con">
                    <li><a href="detail_data.jsp?detail=书籍">书籍</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=专业资料">专业资料</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=考研资料">考研资料</a></li><li> | </li>
                </ul>
    
                <ul class="others_con">
                    <li><a href="detail_data.jsp?detail=健身器材">健身器材</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=花卉">花卉</a></li><li> | </li>
                    <li><a href="detail_data.jsp?detail=其他">其他</a></li><li> | </li>
                </ul>

            <form class="Form" action="Search" method="POST">
                <input type="text" name="search" class="search" placeholder="请输入查询内容...">
                <input type="submit" value="搜索" class="button">
            </form>

        </div>
        
    </div>
    </div>
  </body>
</html>

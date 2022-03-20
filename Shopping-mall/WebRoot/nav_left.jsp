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
	
    <link rel="stylesheet"  type="text/css"  href="css/nav_left.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/nav_left.js"></script>
    <link rel="icon" href="favicon.ico">
    <base target="view_frame"> 

  </head>
  
  <body>
    <div id="nav_left">
        <!-- 左边顶部信息 -->
        <div class="nav_left_personal">
            <h3>个人中心</h3>
            <ul class="personal">
                <li><a href="alter_personal.jsp?id=${user.id }" target="_top">修改信息</a></li>
                <li><a href="alterPassword.jsp?id=${user.id }" target="_top">修改密码</a></li>
                <li><a href="goods.jsp?id=${user.id }">商品发布</a></li>
                <li><a href="Mygoods?op=show">我的发布</a></li>
            </ul>

            
        </div>

        <!-- 左边中部导航 -->
        <div class="nav_left_top">
            <h3>商品分类</h3>
            <ul class="top">
                <li><h4 class="item">全部商品</h4>
                    <ul class="all">
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=手机">手机</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=电脑">电脑</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=相机">相机</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=衣服">衣服</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=数据">书籍</a></li>
                   	 	<li><img src="images/list.png"><a href="detail_data.jsp?detail=健身器材">健身器材</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=学习资料">学习资料</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=洗衣液">洗衣液</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=床上物品">床上物品</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=考研资料">考研资料</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=花卉">花卉</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=其他">其他</a></li>              
                    </ul>
                </li>
                <li><h4 class="item">电子产品</h4>
                    <ul class="Electronics">
                        <li><img src="images/list.png"><a href="detail_data.jsp?detail=手机">手机</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=电脑">电脑</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=相机">相机</a></li>
                    </ul>
                </li>
                <li><h4 class="item">生活用品</h4>
                    <ul class="life">
                        <li><img src="images/list.png"><a href="detail_data.jsp?detail=洗衣液">洗衣液</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=衣服">衣服</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=床单">床单</a></li>
                    </ul>
                </li>
                <li><h4 class="item">学习用品</h4>
                    <ul class="study">
                        <li><img src="images/list.png"><a href="detail_data.jsp?detail=书籍">书籍</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=专业资料">专业资料</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=考研资料">考研资料</a></li>
                    </ul>
                </li>
                <li><h4 class="item">其他分类</h4>
                    <ul class="others">
                        <li><img src="images/list.png"><a href="detail_data.jsp?detail=健身器材">健身器材</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=花卉">花卉</a></li>
                    	<li><img src="images/list.png"><a href="detail_data.jsp?detail=其他">其他</a></li>
                    </ul>
                </li>
            </ul>
        </div>

        <!-- 左边底部导航 -->
        <div class="nav_left_bottom">
            <h3>最近浏览</h3>
            
        </div>

    </div>
    
  </body>
</html>

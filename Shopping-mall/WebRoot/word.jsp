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
	
    <link rel="stylesheet"  type="text/css"  href="css/word.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/word.js"></script>
    <link rel="icon" href="favicon.ico">
    <base target="_blank">
</head>
<body>
    
    
    <div class="head">
        <a href="">我要留言</a>
        <a href="">我的留言</a>
    </div>

    <div class="main">
        <div class="in_main">
            <div class="title">
                <a href="">留言板</a>
                <div class="page">
                    <a href="">上一页</a>
                    <a href="">下一页</a>
                </div>           
            </div>
            
            <div class="word">
                <div class="word_content">
                    <div class="userName">
                        昵称：<a href="">曾为</a>
                        
                        <ul class="arrow">
                            <li><img src="images/option.png"></li>
                            <div class="option">
                                <li><a href="">删除</a></li>
                                <li><a href="">引用</a></li>
                            </div>
                            
                        </ul>
                    </div>
                    <div class="content">
                        愿你走进自己心中的那所学校
                    </div>
                    <div class="return">
                        <span>2020-12-19</span>
                        <a href="">回复</a>
                    </div>
                </div>  

                <div class="return_word">
                    <p>昵称：<a href="">小宝</a><span>你也是</span></p>
                    <div class="time">
                        <span>2020-12-19</span>
                        <span>16:20</span>
                    </div>
                    <input type="text" placeholder="我也说一句..." class="input_bottom">

                    <form action="" method="POST" target="_self" class="form">
                        <textarea name="" id="" cols="30" rows="3" class="return_message"></textarea>
                        <div>
                            <input type="submit" value="确定" class="return_submit">
                            <a href="word.jsp" target="_self" class="return_reset">取消</a>
                        </div>
                    </form>

                    
                </div>
            </div>

            <div class="bottom_page">
                <div>
                    <a href="">我要留言</a>
                    <a href="">批量管理</a>
                </div>
                
            </div>
        </div>
    </div>

    <!-- 顶部导航 -->
    <div class="nav_top">
        <img src="images/top.png" alt="回到顶部">
        <div class="top">回到顶部</div>
    </div>


<!-- 删除 -->
    <div class="head">
        <a href="">我要留言</a>
        <a href="">我的留言</a>
    </div>

    <div class="main">
        <div class="in_main">
            <div class="title">
                <a href="">留言板</a>
                <div class="page">
                    <a href="">上一页</a>
                    <a href="">下一页</a>
                </div>           
            </div>
            
            <div class="word">
                <div class="word_content">
                    <div class="userName">
                        昵称：<a href="">曾为</a>
                        
                        <ul class="arrow">
                            <li><img src="images/option.png"></li>
                            <div class="option">
                                <li><a href="">删除</a></li>
                                <li><a href="">引用</a></li>
                            </div>
                            
                        </ul>
                    </div>
                    <div class="content">
                        愿你走进自己心中的那所学校
                    </div>
                    <div class="return">
                        <span>2020-12-19</span>
                        <a href="">回复</a>
                    </div>
                </div>  

                <div class="return_word">
                    <p>昵称：<a href="">小宝</a><span>你也是</span></p>
                    <div class="time">
                        <span>2020-12-19</span>
                        <span>16:20</span>
                    </div>
                    <input type="text" placeholder="我也说一句..." class="input_bottom">

                    <form action="" method="POST" target="_self" class="form">
                        <textarea name="" id="" cols="30" rows="3" class="return_message"></textarea>
                        <div>
                            <input type="submit" value="确定" class="return_submit">
                            <a href="word.jsp" target="_self" class="return_reset">取消</a>
                        </div>
                    </form>

                    
                </div>
            </div>

            <div class="bottom_page">
                <div>
                    <a href="">我要留言</a>
                    <a href="">批量管理</a>
                </div>
                
            </div>
        </div>
    </div>


    <div class="head">
        <a href="">我要留言</a>
        <a href="">我的留言</a>
    </div>

    <div class="main">
        <div class="in_main">
            <div class="title">
                <a href="">留言板</a>
                <div class="page">
                    <a href="">上一页</a>
                    <a href="">下一页</a>
                </div>           
            </div>
            
            <div class="word">
                <div class="word_content">
                    <div class="userName">
                        昵称：<a href="">曾为</a>
                        
                        <ul class="arrow">
                            <li><img src="images/option.png"></li>
                            <div class="option">
                                <li><a href="">删除</a></li>
                                <li><a href="">引用</a></li>
                            </div>
                            
                        </ul>
                    </div>
                    <div class="content">
                        愿你走进自己心中的那所学校
                    </div>
                    <div class="return">
                        <span>2020-12-19</span>
                        <a href="">回复</a>
                    </div>
                </div>  

                <div class="return_word">
                    <p>昵称：<a href="">小宝</a><span>你也是</span></p>
                    <div class="time">
                        <span>2020-12-19</span>
                        <span>16:20</span>
                    </div>
                    <input type="text" placeholder="我也说一句..." class="input_bottom">

                    <form action="" method="POST" target="_self" class="form">
                        <textarea name="" id="" cols="30" rows="3" class="return_message"></textarea>
                        <div>
                            <input type="submit" value="确定" class="return_submit">
                            <a href="word.jsp" target="_self" class="return_reset">取消</a>
                        </div>
                    </form>

                    
                </div>
            </div>

            <div class="bottom_page">
                <div>
                    <a href="">我要留言</a>
                    <a href="">批量管理</a>
                </div>
                
            </div>
        </div>
    </div>
    
    
</body>
</html>
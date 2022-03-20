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
	
    <link rel="stylesheet"  type="text/css"  href="css/cart_data.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/cart_data.js"></script>
    <link rel="icon" href="favicon.ico">

  </head>
  
  <body>
  
  <%
  	String alert = (String)request.getSession().getAttribute("cart");
   %>
    <div id="mainContent">
        <div class="contain">
            <h2>我的购物车</h2>
            <div class="prompt"><%=alert %></div>
            <table class="table">
                <thead>
                    <tr>
                        <th><input type="checkbox" name="" class="checkAll">&nbsp;全选</th>
                        <th>商品名称</th>
                        <th>种类</th>
                        <th>发布者</th>
                        <th>联系方式</th>                    
                        <th>数量</th>
                        <th>单价</th>
                        <th>选购数量</th>
                        <th>小计</th>
                        <th>操作</th>
                    </tr>
                </thead>

                <tbody>
                <%
                	ArrayList<Cart_bean> list = (ArrayList<Cart_bean>)request.getSession().getAttribute("list");
                	Iterator<Cart_bean> it = list.iterator();
                	while(it.hasNext()){
                		Cart_bean bean = (Cart_bean)it.next();
                 %>
                    <tr class="main">
                        <td class="m_checkbox"><input type="checkbox" name="" class="m_check"></td>
                        <td><%=bean.getGoodsName() %></td>
                        <td><%=bean.getKind() %></td>
                        <td><%=bean.getName() %></td>
                        <td><%=bean.getPhone() %></td>
                        <td><%=bean.getNum() %></td>
                        <td class="m_price">￥<%=bean.getPrice() %></td>
                        <td class="m_num">
                            <div class="m_form">
                                <a href="javascript:;" class="decrease">-</a>
                                <input type="text" value="1" class="t_val">
                                <a href="javascript:;" class="increase">+</a>
                            </div>                                                   
                        </td>
                        <td class="m_sum">￥<%=bean.getPrice() %></td>
                        <td class="m_action"><a href="delete_cart?phone=<%=bean.getPhone() %>&name=<%=bean.getGoodsName() %>&op=delete" target="_top">移除</a></td>
                    </tr>
                    <%} %>
                </tbody>
            </table>
        </div>
        <!-- 结算 -->
        <div class="mainBottom">
			<div class="m_b_left">
				<div class="ckAll">
					<input type="checkbox" name="" class="checkAll">&nbsp;全选
				</div>
				<div class="clearSome">
					<a href="#">删除选中的商品</a>
				</div>
				<div class="clearAll">
					<a href="delete_cart?op=all" target="_top">清空购物车</a>
				</div>
			</div>
			<div class="m_b_right">
				<div class="s_goods">已选<em>0</em>件商品</div>
				<div class="t_sum">总价:<em>￥0.00</em></div>
				<div class="t_submit"><a>去结算</a></div>
			</div>
		</div>
</div>
<!-- 支付 -->
<div class="pay">
    <p>请选择一种支付方式进行支付</p>
    <p>扫下方二维码进行支付</p>
    <p class="money"></p>
    <img src="images/Wechart_pay.png">
    <img src="images/Ali_pay.png">
</div>
</body>
</html>

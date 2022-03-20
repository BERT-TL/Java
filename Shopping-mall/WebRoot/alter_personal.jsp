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
	    
    <link rel="stylesheet"  type="text/css"  href="css/alter_personal.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="js/register.js"></script>
    <link rel="icon" href="favicon.ico">
    
  </head>
  
  <body>
  
  <%
  		String id = request.getParameter("id");
		User_dao dao = new User_dao();
		User_bean bean = dao.find(id);
		
		String institute = bean.getInstitute();
		
		
   %>
    
    <div class="main">
            <h2>修改个人信息</h2>
            <p class="alert">(注：下列信息中带“*”号的为必填内容)</p>
            <div class="register">
                <form action="alter_personal" οnsubmit="return checkAll();">
                    <ul>
                        <li>
                            <div><span>* </span>用户名：</div>
                            <input type="text" required="required" onblur="checkName()" placeholder="请输入昵称" readonly name="id" value="<%=bean.getId() %>">
                        </li>
                        <li>
                            <div><span>* </span>昵称：</div>
                            <input type="text" required="required" onblur="checkName()" placeholder="请输入昵称" id="name" name="name" value="<%=bean.getName() %>">
                            <span id="nameSpan"></span>
                        </li>
                                                           
                        <li>
                            <div><span>* </span>邮箱：</div>
                            <input type="email" onblur="checkEmail()" placeholder="请输入邮箱号" id="email" name="e_mail" value="<%=bean.getE_mail() %>">
                            <span id="emailSpan"></span>
                        </li>
                    
                        <!-- <li><div>出生日期：</div><input type="date"><span></span></li> -->
                        <!-- <li class="sex"><div><span>* </span>性别：</div><input type="radio" name="sex" value="男" checked>&nbsp;男<input type="radio" name="sex" value="女">&nbsp;女</li> -->
                        <li>
                            <div><span>* </span>联系方式：</div>
                            <input type="text" required="required" placeholder="请输入联系方式" onblur="checkManner()" id="manner" name="phone" value="<%=bean.getPhone() %>">
                            <span id="mannerSpan"></span>
                        </li>
                        <li>
                            <div><span>* </span>学院：</div>
                            <select name="institute" class="institute">
                                <option value="计算机科学与工程学院">计算机科学与工程学院</option>
                                <option value="电子信息与工程学院" selected>电子信息与工程学院</option>
                                <option value="国际商学院">国际商学院</option>
                                <option value="艺术学院">艺术学院</option>
                                <option value="管理学院">管理学院</option>
                            </select>
                        </li>
                        <li class="inp">
                            <p><input type="submit" value="确定"><input type="reset" value="重置" id="reset"></p>
                            
                        </li>
                    </ul>
                </form>
            </div>  
        </div>
                            	<!--  <%
                            		if(institute.equals("计算机科学与工程学院")){
                            			out.print("<option value='计算机科学与工程学院' selected>计算机科学与工程学院</option>");
                            			out.print("<option value='电子信息与工程学院'>电子信息与工程学院</option>");
                            			out.print("<option value='国际商学院'>国际商学院</option>");
                            			out.print("<option value='艺术学院'>艺术学院</option>");
                            			out.print("<option value='管理学院'>管理学院</option>");
                            		} else{
                            	
                            			if (institute.equals("电子信息与工程学院")){
                            				out.print("<option value='计算机科学与工程学院'>计算机科学与工程学院</option>");
                            				out.print("<option value='电子信息与工程学院' selected>电子信息与工程学院</option>");
                            				out.print("<option value='国际商学院'>国际商学院</option>");
                            				out.print("<option value='艺术学院'>艺术学院</option>");
                            				out.print("<option value='管理学院'>管理学院</option>");
                            			}else{
                            			 		if (institute.equals("国际商学院")){
                            					out.print("<option value='计算机科学与工程学院'>计算机科学与工程学院</option>");
                            					out.print("<option value='电子信息与工程学院'>电子信息与工程学院</option>");
                            					out.print("<option value='国际商学院' selected>国际商学院</option>");
                            					out.print("<option value='艺术学院'>艺术学院</option>");
                            					out.print("<option value='管理学院'>管理学院</option>");
                            				} else{
                            						if (institute.equals("艺术学院")){
                            						out.print("<option value='计算机科学与工程学院'>计算机科学与工程学院</option>");
                            						out.print("<option value='电子信息与工程学院'>电子信息与工程学院</option>");
                            						out.print("<option value='国际商学院'>国际商学院</option>");
                            						out.print("<option value='艺术学院' selected>艺术学院</option>");
                            						out.print("<option value='管理学院'>管理学院</option>");
                            					} else{
                            							if (institute.equals("管理学院")){
                            							out.print("<option value='计算机科学与工程学院'>计算机科学与工程学院</option>");
                            							out.print("<option value='电子信息与工程学院'>电子信息与工程学院</option>");
                            							out.print("<option value='国际商学院'>国际商学院</option>");
                            							out.print("<option value='艺术学院'>艺术学院</option>");
                            							out.print("<option value='管理学院' selected>管理学院</option>");
                            						}     
                            					}
                            				}
                            			}
                            			
                            		}
                            		
                            		
                            		             	
                            	%>-->
      
                         
</html>

<%@page import="java.net.URLEncoder"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>请求</title>
  </head>
  
  <body>
    <%-- <form action="${pageContext.request.contextPath}/servlet/RequestDemo" method="post">
    	<input type="text" name="uname" ><br>
    	<input type="text" name="uname" ><br>    	
    	<input type="submit" value="提交">
    </form> --%>
    
     <%-- <form action="${pageContext.request.contextPath}/servlet/RequestDemo" method="get">
    	用户1：<input type="text" name="uname" ><br>
    	用户2：<input type="text" name="uname" ><br>
    	密码：<input type ="password" name="pwd"><br>    	
    	<input type="submit" value="提交">
    </form> --%>
    
    <!-- 超链接形式传递中文参数的乱码问题  注意超链接方式也是一种get方式请求 -->
    
    <!--这样还是乱码  -->
     <a href="${pageContext.request.contextPath}/servlet/RequestDemo1?name=<%=URLEncoder.encode("徐达", "UTF-8")%>">测试是否乱码</a>
    
 	<!-- 成功 -->
 	<a href="${pageContext.request.contextPath}/servlet/RequestDemo2?name=徐达">测试是否乱码</a>
    
  </body>
</html>

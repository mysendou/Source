<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <center>
        <h1>请登录</h1>
        <form action="http://check.x.com/SSOProjectSameFather/sso/doLogin.action" method="post">
            <span>用户名：</span><input type="text" name="username"/>
            <span>密码：</span><input type="password" name="password"/>
            <input type="hidden" name="gotoUrl" value="${gotoUrl}"/>
            <input type="submit" value="提交"/>
        </form>
    </center>
  </body>
</html>

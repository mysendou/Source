<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String context = request.getContextPath(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
Result类型
<ol>
	<li><a href="user/user?type=1">返回success</a></li>
	<li><a href="user/user?type=2">返回error</a></li>
	<li><a href="user/user?type=3">返回global result</a></li>
	<li><a href="admin/admin">admin,继承user包</a></li>
</ol>
	
</body>
</html>
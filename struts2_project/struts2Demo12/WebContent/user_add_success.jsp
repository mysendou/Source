<?xml version="1.0" encoding="GB18030" ?>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<title>Insert title here</title>
</head>
<body>
    User Add Success!<br />
        <br />
    <s:property value="#request.request"/> | <%=request.getAttribute("request") %> <br />
    <s:property value="#session.session"/> | <%=session.getAttribute("session") %> <br />
    <s:property value="#application.application"/> | <%=application.getAttribute("application") %> <br />
    <s:property value="#attr.a1"/><br />
    <s:property value="#attr.s1"/><br />
    <s:property value="#attr.r1"/><br />
    <s:debug></s:debug>
    <br />
</body>
</html>
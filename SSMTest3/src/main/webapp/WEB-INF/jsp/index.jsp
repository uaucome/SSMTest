<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath()%>/">
<title>首页</title>
</head>
<body style="text-align: center">
	<div style="background-color: #00FFFF;width: 650px;height: 350px;margin-left: 450px;padding-top: 5px;">
	<div style="text-align:left;font-size:16px;font-weight: bold;">欢迎您， ${user.username }${user.sex == "男" ? "先生" : "女士" }！</div>
	<div style="text-align:right;font-size:16px;font-weight: bold;">
	<a href="javascript:void(0)" style="text-decoration: none; color: black;">个人信息</a>&nbsp;&nbsp;
	<a href="exit" style="text-decoration: none; color: black;">退出</a>
	</div>	
	</div>
</body>
</html>

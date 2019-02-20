<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息表</title>
</head>
<body>
	<div style="background-color: #00FFFF; width: 650px; height: 350px; margin-left: 450px; padding-top: 10px;">
		<h2 style="text-align: center">用 户 信 息</h2>
		<div style="font-size: 15px; font-weight: bold; text-align: right; padding-right: 50px;">
			<a href="javascript:void(0)" style="text-decoration: none; color: black;" onclick="registe()">编辑</a>
			&nbsp;&nbsp;&nbsp;&nbsp;  
			<a href="index" style="text-decoration: none; color: black;">返回</a>
		</div>
		<div style="font-size: 15px; font-weight: bold; padding-top: 10px; padding-left: 184px;">
			昵称:&nbsp;&nbsp;${user.username }
		</div>
		<div style="font-size: 15px; font-weight: bold; padding-top: 10px; padding-left: 184px;">
			年龄:&nbsp;&nbsp;${user.age }
		</div>
		<div style="font-size: 15px; font-weight: bold; padding-top: 10px; padding-left: 184px;">
			性别:&nbsp;&nbsp;${user.sex }
		</div>
		<div style="font-size: 15px; font-weight: bold; padding-top: 10px; padding-left: 184px;">
			账号:&nbsp;&nbsp;${user.account }
		</div>
		<div style="font-size: 15px; font-weight: bold; padding-top: 50px; padding-left: 201px;">
			说明:&nbsp;&nbsp;暂不支持账号信息的修改
		</div>
	</div>
</body>
</html>
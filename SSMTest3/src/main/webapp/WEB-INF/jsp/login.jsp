<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	$(function(){
		var msg = '${msg}';
		if(msg != "" && msg != null){
			alert(msg);
		}else{
			
		}
	})
	//账号校验
	function accountCheck(){
		var reg = new RegExp("^[0-9]*$");
		var regLength = new RegExp("^[0-9]{6,10}$");
		var account = $("#account").val();
		
		//判断账号不为空
		if(account == null || account == ""){
			$("#accountError").html("账号不能为空");
			return false;
		}else{
			$("#accountError").html("");
		}
		
		//判断账号只能为数字
		if(!reg.test(account)){
			$("#accountError").html("账号中只能为数字");
			return false;
		}else{
			$("#accountError").html("");
		} 
		
		//判断账号的长度为6-10位
		if(!regLength.test(account)){
			$("#accountError").html("账号的长度为6-10位");
			return false;
		}else{
			$("#accountError").html("");
		} 
		
		return true;
	}
	
	//密码校验
	function passwordCheck(){
		var password = $("#password").val();
		var regLength = new RegExp("^[0-9]{1,11}$");
		
		//判断密码不为空
		if(password == null || password == ""){
			$("#passwordError").html("密码不能为空");
			return false;
		}else{
			$("#passwordError").html("");
		}
		
		//判断密码的长度为1-11位
		if(!regLength.test(password)){
			$("#passwordError").html("密码的长度为1-11位");
			return false;
		}else{
			$("#passwordError").html("");
		} 
		
		return true;
	}
	
	//登陆校验
	function login(){
		var account = $("#account").val();
		var password = $("#password").val();
		var accountResult = accountCheck();
		var pwResult = passwordCheck();
		//alert(accountResult);
		//alert(pwResult);
		if(!accountResult || !pwResult ){
			return false;
		}
		//全部符合标准的话，执行ajax
		//alert("即将进入post请求");
		var url = "login";
		$.ajax({
			url: url,
			type: 'post',
			data: {"account":account,"password":password},
			success:function(data){
				if(data != "该账号可以登录"){
					alert(data);
				}else{
					//跳转首页
					//alert("登录开始");
					window.location.href="index";
				}
			}
		})
	}
</script>
</head>
<body>
	<div style="background-color: #00FFFF; width: 650px; height: 350px; margin-left: 450px; padding-top: 10px;">
		<h2 style="text-align: center">Login &nbsp;&nbsp; Page</h2>
		<div style="font-size: 18px; font-weight: bold; padding-top: 10px; padding-left: 200px;">
			Account:&nbsp;&nbsp;<input type="text" id="account" name="acount" onblur="accountCheck()" />&nbsp;<span id="accountError" style="font-size: 15px; font-weight: bold; color:red;"></span>
		</div>
		<div style="font-size: 18px; font-weight: bold; padding-left: 188px;">
			Password:&nbsp;&nbsp;<input type="password" id="password" name="password" onblur="passwordCheck()" />&nbsp;<span id="passwordError" style="font-size: 15px; font-weight: bold; color:red;"></span>
		</div>
		<div style="font-size: 18px; font-weight: bold; padding-top: 50px; text-align: center;">
			<a href="javascript:void(0)" style="text-decoration: none; color: black;" onclick="login()">Login</a>
			&nbsp;&nbsp; 
			<a href="home" style="text-decoration: none; color: black;">Back</a>
		</div>
	</div>
</body>
</html>
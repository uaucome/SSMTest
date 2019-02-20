<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath()%>/">
<title>注册</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

	//昵称校验
	function nickNameCheck(){
		var nickeName = $("#nickName").val();
		
		//昵称不能为空
		if(nickeName == null || nickeName == ""){
			$("#nickeNameError").html("注册昵称不能为空");
			return false;
		}else{
			$("#nickeNameError").html("");
		}
		
		return true;
	}
	
	//账号校验
	function accountCheck(){
		var reg = new RegExp("^[0-9]*$");
		var regLength = new RegExp("^[0-9]{6,10}$");
		var account = $("#account").val();
		
		//注册账号不为空
		if(account == null || account == ""){
			$("#accountError").html("注册账号不能为空");
			return false;
		}else{
			$("#accountError").html("");
		}
		
		//注册账号只能为数字
		if(!reg.test(account)){
			$("#accountError").html("注册账号中只能为数字");
			return false;
		}else{
			$("#accountError").html("");
		} 
		
		//注册账号的长度为6-10位
		if(!regLength.test(account)){
			$("#accountError").html("注册账号的长度为6-10位");
			return false;
		}else{
			$("#accountError").html("");
		} 
		
		return true;
	}
	
	//一次密码校验
	function passwordCheck(){
		var password = $("#password").val();
		var regLength = new RegExp("^[A-Za-z0-9]{1,11}$");
		
		//判断密码不为空
		if(password == null || password == ""){
			$("#passwordError").html("密码不能为空");
			return false;
		}else{
			$("#passwordError").html("");
		}
		
		//判断密码的长度为1-11位
		if(!regLength.test(password)){
			$("#passwordError").html("密码只能为长度1-11位的数字和英文");
			return false;
		}else{
			$("#passwordError").html("");
		} 
		
		return true;
	}
	
	//二次密码校验
	function passwordConfirmCheck(){
		var password = $("#password").val();
		var passwordConfirm = $("#passwordConfirm").val();
		
		//判断二次输入密码不为空
		if(passwordConfirm == null || passwordConfirm == ""){
			$("#passwordConfirmError").html("确认密码不能为空");
			return false;
		}else{
			$("#passwordConfirmError").html("");
		}
		
		
		//判定2次输入的密码是否一致
		if(password != passwordConfirm){
			$("#passwordConfirmError").html("两次密码不一致");
			return false;
		}else{
			$("#passwordConfirmError").html("");
		}
		
		return true;
	}
	
	//注册校验
	function registe(){
		//先过检验
		var nickNameResult = nickNameCheck();
		var accountResult = accountCheck();
		var pwResult = passwordCheck();
		var pwConfirmResult = passwordConfirmCheck();
		
		//alert("昵称判定："+nickNameResult);
		//alert("账号判定"+accountResult);
		//alert("密码判定"+pwResult);
		//alert("密码确认判定"+pwConfirmResult);
		if(!nickNameResult || !accountResult || !pwResult || !pwConfirmResult){
			return false;
		}
		
		//全部符合标准的话，执行ajax
		//alert("即将进入post请求")
		var nickeName = $("#nickName").val();
		var account = $("#account").val();
		var password = $("#password").val();
		var url = "registe";
		$.ajax({
			url: url,
			type: 'post',
			data: {"username":nickeName,"account":account,"password":password},
			success:function(data){
				if(data != "success"){
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
		<h2 style="text-align: center">Registe &nbsp;&nbsp; Page</h2>
		<div style="font-size: 18px; font-weight: bold; padding-top: 10px; padding-left: 184px;">
			Nickname:&nbsp;&nbsp;<input type="text" id="nickName" name="nickName" onblur="nickNameCheck()" />&nbsp;<span id="nickeNameError" style="font-size: 15px; font-weight: bold; color:red;"></span>
		</div>
		<div style="font-size: 18px; font-weight: bold; padding-left: 200px;">
			Account:&nbsp;&nbsp;<input type="text" id="account" name="acount" onblur="accountCheck()" />&nbsp;<span id="accountError" style="font-size: 15px; font-weight: bold; color:red;"></span>
		</div>
		<div style="font-size: 18px; font-weight: bold; padding-left: 188px;">
			Password:&nbsp;&nbsp;<input type="password" id="password" name="password" onblur="passwordCheck()" />&nbsp;<span id="passwordError" style="font-size: 15px; font-weight: bold; color:red;"></span>
		</div>
		<div style="font-size: 18px; font-weight: bold; padding-left: 201px;">
			Confirm:&nbsp;&nbsp;<input type="password" id="passwordConfirm" name="passwordConfirm" onblur="passwordConfirmCheck()" />&nbsp;<span id="passwordConfirmError" style="font-size: 15px; font-weight: bold; color:red;"></span>
		</div>
		<div style="font-size: 18px; font-weight: bold; padding-top: 50px; text-align: center;">
			<a href="javascript:void(0)" style="text-decoration: none; color: black;" onclick="registe()">Registe</a>
			&nbsp;&nbsp; 
			<a href="" style="text-decoration: none; color: black;">Back</a>
		</div>
	</div>
</body>
</html>
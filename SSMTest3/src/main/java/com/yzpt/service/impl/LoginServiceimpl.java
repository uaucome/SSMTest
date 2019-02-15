package com.yzpt.service.impl;

import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzpt.entity.Account;
import com.yzpt.entity.User;
import com.yzpt.mapper.LoginMapper;
import com.yzpt.mapper.UserMapper;
import com.yzpt.service.LoginService;

@Service
public class LoginServiceimpl implements LoginService {
	
	private static final Logger logger = LogManager.getLogger(LoginServiceimpl.class);
	private LoginMapper systemMapper;
	private UserMapper userMapper;
	
	@Autowired
	public LoginServiceimpl(LoginMapper systemMapper,UserMapper userMapper) {
		this.systemMapper = systemMapper;
		this.userMapper = userMapper;
	}

	@Override
	public String getAccountInfo(HttpServletRequest request,String account, String password) {
		String message = "";
		try {
			Account accounts = systemMapper.getAccountInfo(account);
			if(accounts != null) {
				//账号存在
				if(accounts.getPassword().equals(password)) {
					//密码正确
					//保存用户信息
					User user = userMapper.getUserInfo(accounts.getId());	
					request.getSession().setAttribute("user", user);
					message = "该账号可以登录";
				}else {
					message = "密码错误";
				}	
			}else {
				message = "账号不存在";
			}
		}catch (Exception e) {
			logger.info("SQL-查询账号或者用户信息失败：" + e);
		}
		return message;
	}

}

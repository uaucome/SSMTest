package com.yzpt.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzpt.entity.Account;
import com.yzpt.entity.User;
import com.yzpt.mapper.LoginMapper;
import com.yzpt.mapper.RegisteMapper;
import com.yzpt.service.RegisteService;

/**
 * Description:注册业务实现
 *
 * @author yzp
 *
 * @date 2019年2月19日
 *
 */
@Service
public class RegisteServiceImpl implements RegisteService{
	private static final Logger logger = LogManager.getLogger(RegisteServiceImpl.class);
	private LoginMapper loginMapper;
	private RegisteMapper registeMapper;
	
	@Autowired
	public RegisteServiceImpl(RegisteMapper registeMapper, LoginMapper loginMapper) {
		this.registeMapper = registeMapper;
		this.loginMapper = loginMapper;
	}

	@Override
	public String registeUser(HttpServletRequest request, String username, String account, String password) {
		//判定账号是否存在
		String result = "";
		Account accounts = loginMapper.getAccountInfo(account);
		if(accounts != null) {
			result = "该账号已存在";
		}else {
			User user = new User();
			user.setUsername(username);
			user.setAccount(account);
			
			Account accountinfo = new Account();
			accountinfo.setAccount(account);
			accountinfo.setPassword(password);
			
			int accountid = 0 ;
			int userResult = 0;
			try {
				//注册账号,并获取其id,将id赋给user,暂时这么考虑
				accountid = registeMapper.addAccount(accountinfo);
				user.setAccount(accountinfo.getId().toString());
				userResult = registeMapper.addUser(user);
				request.getSession().setAttribute("user", user);
			}catch (Exception e) {
				logger.info("SQL保存用户或账号失败：" + e);
			}
			if(accountid == 1 && userResult == 1) {
				result = "success";
			}else {
				result = "注册失败";
			}
		}
		
		return result;
	}

}

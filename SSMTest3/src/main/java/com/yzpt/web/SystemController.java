package com.yzpt.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzpt.entity.User;
import com.yzpt.service.SystemService;
import com.yzpt.utils.CommonUtils;

@Controller
public class SystemController {
	
	private static final Logger logger = LogManager.getLogger(SystemController.class);
	private SystemService systemService;
	
	@Autowired
	public SystemController(SystemService systemService) {
		this.systemService = systemService;
	}
	
	//登录页面
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginJsp() {
		return "login";
	}
	
	//注册页面
	@RequestMapping(value="/registe",method=RequestMethod.GET)
	public String getRegisteJsp() {
		return "registe";
	}
	
	//登录
	@RequestMapping(value="login",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String login(HttpServletRequest request) {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String message = systemService.getAccountInfo(request,account,password);
		return message;
	}
	
	//首页
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String getIndeJsp() {
		return "index";
	}
	
	//退出
	@RequestMapping(value="/exit",method=RequestMethod.GET)
	public String exit(HttpServletRequest request) {
		//要是购物车的话最好用这个removeAttribute,清空session
		//用户下线前记录一下
		logger.info("用户[" + ((User) request.getSession().getAttribute("user")).getUsername() + "]下线,时间:"+CommonUtils.getDate());
		request.getSession().removeAttribute("user");
		return "login";
	}
}

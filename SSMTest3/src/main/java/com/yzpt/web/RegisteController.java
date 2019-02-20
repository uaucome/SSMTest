package com.yzpt.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzpt.service.RegisteService;

/**
 * Description:注册控制器
 *
 * @author yzp
 *
 * @date 2019年2月19日
 *
 */
@Controller
public class RegisteController {

	private RegisteService registeService;
	
	@Autowired
	public RegisteController(RegisteService registeService) {
		this.registeService = registeService;
	}
	
	@RequestMapping(value="registe",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String registeUser(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		//暂时不考虑多账号的问题，唯一值为账号
		String result = registeService.registeUser(request,username,account,password);
		return result;
	}
}

package com.yzpt.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping(value="userInfo")
	public String getUserInfoJsp() {
		return "userInfo";
	}
}

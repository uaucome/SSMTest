package com.yzpt.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzpt.entity.Book;
import com.yzpt.entity.User;
import com.yzpt.mapper.UserMapper;

@Controller
@RequestMapping
public class BookController {
	private static final Logger logger = LogManager.getLogger(BookController.class);
	private UserMapper userMapper;
	
	@Autowired
	public BookController(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@RequestMapping(value ="/test" , produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getResult() {
		return "Hello,EveryOne,I'm ZhaZhaHui!\n大家好，我是渣渣辉！";
	}
	
	@RequestMapping(value ="/Test")
	public String getTestInfo(HttpServletRequest request) {
		Book book = new Book();
		book.setBookId("10086");
		book.setWriter("YZP");
		book.setBookName("论客户的重要性");
		book.setPublishingHouse("HaoYiTec");
		request.setAttribute("book",book);
		return "test";
	}
	
	@RequestMapping(value ="/ssm")
	public String getUserInfo(HttpServletRequest request) {
		String strid = request.getParameter("id");
		User user;
		try {	
			user = userMapper.getUserInfor(Integer.valueOf(strid));
			logger.info(user.getUsername());
			logger.info(user.getAge());
			logger.info(user.getSex());
			request.setAttribute("user", user);
		}catch (Exception e) {
			logger.info("获取User信息失败 :" + e );
		}
		return "user";
	}
}

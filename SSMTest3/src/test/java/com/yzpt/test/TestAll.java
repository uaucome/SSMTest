package com.yzpt.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzpt.entity.Book;
import com.yzpt.entity.User;
import com.yzpt.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestAll {
	private static final Logger logger = LogManager.getLogger(TestAll.class);

	@Autowired
	private UserMapper usermapper;
	
	@Test
	public void testSpring() {
		
		@SuppressWarnings("resource")
		ApplicationContext ac =  new ClassPathXmlApplicationContext("applicationContext.xml");
		Book book = (Book) ac.getBean("book");
		
		logger.info(book.getBookId());
		logger.info(book.getBookName());
		logger.info(book.getWriter());
		logger.info(book.getPublishingHouse());
		
	}
	
	@Test
	public void testSSM() {
		int id1 = 1;
		try {	
			User user1 = usermapper.getUserInfor(id1);
			logger.info("用户1姓名:" + user1.getUsername());
			logger.info("用户1年龄:" +user1.getAge());
			logger.info("用户1性别:" +user1.getSex());
		}catch (Exception e) {
			logger.info("SQL查询失败！"+e);
		}	
	}
}

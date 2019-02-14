package com.yzpt.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yzpt.entity.User;
import com.yzpt.utils.CommonUtils;

public class UserSessionListener implements HttpSessionListener,HttpSessionAttributeListener{
	private static final Logger logger = LogManager.getLogger(UserSessionListener.class);
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		User user = (User) event.getSession().getAttribute("user");
		if(user != null) {
			logger.info("用户[" + user.getUsername() + "]下线,时间:"+CommonUtils.getDate());
		}
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		User user = (User) event.getSession().getAttribute("user");
		if(user != null) {
			logger.info("用户[" + user.getUsername() + "]上线,时间:"+CommonUtils.getDate());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent envent) {
		
	}
}

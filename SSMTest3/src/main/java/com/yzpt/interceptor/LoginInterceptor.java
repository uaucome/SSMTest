package com.yzpt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yzpt.entity.User;

public class LoginInterceptor implements HandlerInterceptor {

	private static final Logger logger = LogManager.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		if ("/login".equals(url)) {
			request.getSession().setAttribute("msg", "");
			return true;
		} else {
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				logger.info("拦截跳转至login页面！");		
				request.getSession().setAttribute("msg", "您未登录，请先登录!");
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
				return false;
			} else
				request.getSession().setAttribute("msg", "");
				return true;
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

}

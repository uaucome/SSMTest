package com.yzpt.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:注册业务接口
 *
 * @author yzp
 *
 * @date 2019年2月19日
 *
 */
public interface RegisteService {

	String registeUser(HttpServletRequest request, String username, String account, String password);

}

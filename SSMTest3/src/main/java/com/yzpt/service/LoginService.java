package com.yzpt.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

	String getAccountInfo(HttpServletRequest request, String account, String pwbyselect);

}

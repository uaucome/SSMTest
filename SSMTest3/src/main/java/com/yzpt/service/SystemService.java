package com.yzpt.service;

import javax.servlet.http.HttpServletRequest;

public interface SystemService {

	String getAccountInfo(HttpServletRequest request, String account, String pwbyselect);

}

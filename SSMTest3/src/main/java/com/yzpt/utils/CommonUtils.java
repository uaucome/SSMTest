package com.yzpt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
	
	//获取日期字符串
	public static String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		return sdf.format(date);
	}
}

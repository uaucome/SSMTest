package com.yzpt.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	private Integer id;				//用户id
	private String username;		//用户姓名
	private String age;				//年龄
	private String sex;				//性别
	private String account;         //账号
}

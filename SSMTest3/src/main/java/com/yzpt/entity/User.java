package com.yzpt.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	private Integer id;				//用户id
	private Integer accountId;		//用户账号id
	private String userName;		//用户名称
	private String nickName;		//用户昵称	
	private String age;				//用户年龄
	private String sex;				//用户性别
	private String mail;         	//用户邮箱
}

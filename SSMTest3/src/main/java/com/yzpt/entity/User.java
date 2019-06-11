package com.yzpt.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	/**
	 * 1.需要展现什么就提供什么，对应关系在sql中写
	 * 2.根据百度了解的知识以及为了方便维护，还是先用一张表来进行用户信息的存储吧
	 * 3.去掉account的表
	 * 4.注册的时候必填邮箱，方便找回
	 * 5.暂且不考虑分表
	 */
	private Integer id;				//用户id
	private String account;			//用户账号
	private String password;		//用户密码
	private String nickName;		//用户昵称	
	private String age;				//用户年龄
	private String sex;				//用户性别
	private String mail;         	//用户邮箱
	private String photo;			//用户头像
}

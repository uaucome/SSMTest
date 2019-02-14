package com.yzpt.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yzp
 * 图书对象
 */
@Setter
@Getter
public class Book {
	private Integer id;   			//id
	private String bookId;  		//书本id
	private String bookName;		//书本名称
	private String writer;          //作者
	private String publishingHouse; //出版社
}

package com.iflysse.bbs.model;

import java.sql.Date;

public class ReplyInfo {
	 private int id ;
	 private String content;
	 private Date create_date;
	 private int userid ;
	 private int newsid ;
	 private String userName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

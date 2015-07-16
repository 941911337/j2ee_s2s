package com.iflysse.bbs.dao;

import com.iflysse.bbs.model.UserInfo;

public interface UserDao {
	    //根据账户及密码获取用户
		public UserInfo getUser(String account ,String password);
		
		public UserInfo getUser(int id);
		
		//修改密码
		public boolean updatePwd(int userId,String newPwd);
		
		public boolean add(UserInfo user);
		
		 //根据账户获取用户
		public UserInfo getUser(String account);
}

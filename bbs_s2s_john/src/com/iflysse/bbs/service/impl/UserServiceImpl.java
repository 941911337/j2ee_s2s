package com.iflysse.bbs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iflysse.bbs.dao.UserDao;
import com.iflysse.bbs.model.UserInfo;
import com.iflysse.bbs.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserInfo getUser(String account, String password) {
		// TODO Auto-generated method stub
		return userDao.getUser(account, password);
	}

	@Override
	public UserInfo getUser(int id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}

	@Override
	public boolean updatePwd(int userId, String newPwd) {
		// TODO Auto-generated method stub
		return userDao.updatePwd(userId, newPwd);
	}

	@Override
	public boolean add(UserInfo user) {
		// TODO Auto-generated method stub
		return userDao.add(user);
	}

	@Override
	public UserInfo getUser(String account) {
		// TODO Auto-generated method stub
		return userDao.getUser(account);
	}

}

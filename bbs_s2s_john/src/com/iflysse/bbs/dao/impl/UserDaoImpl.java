package com.iflysse.bbs.dao.impl;


import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iflysse.bbs.dao.UserDao;
import com.iflysse.bbs.model.UserInfo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public UserInfo getUser(String account, String password) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		UserInfo user=null;
		String sql="select * from XXOAF_USER where account= ? and PASSWORD = ? ";
		Object[] params=new Object[]{account,password};
		try {
			user=jt.queryForObject(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public UserInfo getUser(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		UserInfo user=null;
		String sql="select * from XXOAF_USER where id = ?";
		try {
			user=jt.queryForObject(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updatePwd(int userId, String newPwd) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		boolean flag=false;
		String sql="update XXOAF_USER set password = ? where id = ?";
		Object[] params=new Object[]{newPwd,userId};
		try {
			int row=jt.update(sql, params);
			flag=row>0?true:false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean add(UserInfo user) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		boolean flag=false;
		String sql="insert into XXOAF_USER(name,account,password,email) values(?,?,?,?)";
		Object[] params=new Object[]{user.getName(),user.getAccount(),user.getPassword(),user.getEmail()};
		try {
			int row = jt.update(sql, params);
			flag=row>0?true:false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public UserInfo getUser(String account) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		UserInfo user=null;
		String sql="select * from XXOAF_USER where account= ? ";
		Object[] params=new Object[]{account};
		try {
			user=jt.queryForObject(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class), params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}

package com.iflysse.bbs.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iflysse.bbs.dao.NewsDao;
import com.iflysse.bbs.model.NewsInfo;

@Repository("newsDao")
public class NewsDaoImpl implements NewsDao {
	
	private DataSource dataSource;

	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	@Override
	public boolean add(NewsInfo news) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		boolean flag=false;
		String sql="insert into XXOAF_news(title,content,create_date,userid) values(?,?,?,?)";
		Object[] params=new Object[]{news.getTitle(),news.getContent(),news.getCreate_date(),news.getUserid()};
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
	public boolean edit(NewsInfo news) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		boolean flag=false;
		String sql="update XXOAF_news set title = ?,content = ?,create_date = ?,userid = ? where id = ?";
		Object[] params=new Object[]{news.getTitle(),news.getContent(),news.getCreate_date(),news.getUserid(),news.getId()};
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
	public boolean deleteById(int id) {
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		boolean flag=false;
		String sql="delete from XXOAF_news where id = ?";
		try {
			int row=jt.update(sql, id);
			flag=row>0?true:false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public NewsInfo getNewsInfo(int id) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		NewsInfo news =null;
		String sql="select * from XXOAF_news where id = ?";
		try {
			news=jt.queryForObject(sql, new BeanPropertyRowMapper<NewsInfo>(NewsInfo.class), id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return news;
	}

	@Override
	public List<NewsInfo> getNewsList() {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		List<NewsInfo> list=null;
		String sql="select n.* ,u.name as username from XXOAF_news n left join XXOAF_USER u on n.userid = u.id";
		try {
			list=jt.query(sql, new BeanPropertyRowMapper<NewsInfo>(NewsInfo.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<NewsInfo> getNewsList(String title) {
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		List<NewsInfo> list=null;
		String sql="select * from XXOAF_news where title like ?";
		try {
			list=jt.query(sql, new BeanPropertyRowMapper<NewsInfo>(NewsInfo.class),"%"+title+"%");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<NewsInfo> getNewsList(int userId) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		List<NewsInfo> list=null;
		String sql="select * from XXOAF_news where userid = ?";
		try {
			list=jt.query(sql, new BeanPropertyRowMapper<NewsInfo>(NewsInfo.class),userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<NewsInfo> getNewsList(String title, int userId) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		List<NewsInfo> list=null;
		String sql="select * from XXOAF_news where title like ? and userId = ? ";
		Object[] params =new Object[]{"%"+title+"%",userId};
		try {
			list=jt.query(sql, new BeanPropertyRowMapper<NewsInfo>(NewsInfo.class) ,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public NewsDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}


	
	
}

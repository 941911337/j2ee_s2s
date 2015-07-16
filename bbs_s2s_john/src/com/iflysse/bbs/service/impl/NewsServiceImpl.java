package com.iflysse.bbs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iflysse.bbs.dao.NewsDao;
import com.iflysse.bbs.model.NewsInfo;
import com.iflysse.bbs.service.NewsService;
@Service("newsService")
public class NewsServiceImpl implements NewsService {
	
	@Resource
	private NewsDao newsDao;
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	@Override
	public boolean add(NewsInfo news) {
		// TODO Auto-generated method stub
		return newsDao.add(news);
	}

	@Override
	public boolean edit(NewsInfo news) {
		// TODO Auto-generated method stub
		return newsDao.edit(news);
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return newsDao.deleteById(id);
	}

	@Override
	public NewsInfo getNewsInfo(int id) {
		// TODO Auto-generated method stub
		return newsDao.getNewsInfo(id);
	}

	@Override
	public List<NewsInfo> getNewsList() {
		// TODO Auto-generated method stub
		return newsDao.getNewsList();
	}

	@Override
	public List<NewsInfo> getNewsList(String title) {
		// TODO Auto-generated method stub
		return newsDao.getNewsList(title);
	}

	@Override
	public List<NewsInfo> getNewsList(int userId) {
		// TODO Auto-generated method stub
		return newsDao.getNewsList(userId);
	}

	@Override
	public List<NewsInfo> getNewsList(String title, int userId) {
		// TODO Auto-generated method stub
		return newsDao.getNewsList(title, userId);
	}

}

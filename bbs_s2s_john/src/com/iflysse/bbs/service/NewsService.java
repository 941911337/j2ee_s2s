package com.iflysse.bbs.service;

import java.util.List;

import com.iflysse.bbs.model.NewsInfo;

public interface NewsService {
	 public boolean add(NewsInfo news);
		
		public boolean edit(NewsInfo news);
		
		public boolean deleteById(int id);
		
		public NewsInfo getNewsInfo(int id);
		
		public List<NewsInfo> getNewsList();
		
		public List<NewsInfo> getNewsList(String title);
		
		public List<NewsInfo> getNewsList(int userId);
		
		public List<NewsInfo> getNewsList(String title,int userId);
}

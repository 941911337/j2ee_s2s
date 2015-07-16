package com.iflysse.bbs.service;

import java.util.List;

import com.iflysse.bbs.model.ReplyInfo;

public interface ReplyService {
	//新增回复
		public boolean add(ReplyInfo reply);
		
		//获取新闻ID获取回复数据
		public List<ReplyInfo> getReplyListByNewsId(int newsId);
		
		public boolean deleteByNewsId(int newsId);
}

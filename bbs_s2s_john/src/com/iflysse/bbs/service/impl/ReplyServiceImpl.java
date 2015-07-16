package com.iflysse.bbs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iflysse.bbs.dao.ReplyDao;
import com.iflysse.bbs.model.ReplyInfo;
import com.iflysse.bbs.service.ReplyService;
@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Resource
	private ReplyDao replyDao;
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	@Override
	public boolean add(ReplyInfo reply) {
		// TODO Auto-generated method stub
		return replyDao.add(reply);
	}

	@Override
	public List<ReplyInfo> getReplyListByNewsId(int newsId) {
		// TODO Auto-generated method stub
		return replyDao.getReplyListByNewsId(newsId);
	}

	@Override
	public boolean deleteByNewsId(int newsId) {
		// TODO Auto-generated method stub
		return replyDao.deleteByNewsId(newsId);
	}

}

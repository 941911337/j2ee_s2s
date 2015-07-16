package com.iflysse.bbs.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iflysse.bbs.dao.NewsDao;
import com.iflysse.bbs.dao.ReplyDao;
import com.iflysse.bbs.dao.UserDao;
import com.iflysse.bbs.model.NewsInfo;
import com.iflysse.bbs.model.ReplyInfo;
import com.iflysse.bbs.model.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller
public class AllAction extends ActionSupport implements SessionAware {
	
	
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private UserInfo user;
	private NewsInfo news;
	private ReplyInfo reply;
	private String newsid;
	private String reurl;
	
	private List<NewsInfo> newsData;
	private List<ReplyInfo> RList=null;
	
	@Resource
	private  UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Resource
	private  NewsDao newsDao;
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	@Resource
	private  ReplyDao replyDao;
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	public String login(){
		UserInfo userInfo=userDao.getUser(user.getAccount(), user.getPassword());
		if(userInfo!=null)
		{
			session.put("currentUser", userInfo);
			if(!reurl.equals("") && !newsid.equals(""))
			{
				return newsDetails();
			}
			else{
				return "login_success";
			}
		}
		else{
			return "login_input";
		}
		
	}
	
	public String index(){
		newsData=newsDao.getNewsList();
		return "index_success";
	}
	
	public String register(){
		
		if(userDao.add(user))
		{
			return "register_success";
		}
		else{
			return "register_input";
		}
		
	}
	
	public String cancel(){
		session.remove("currentUser");
		return "cancel_success";
	}
	
	public String newsDetails(){
		if(reply!=null){
			news=newsDao.getNewsInfo(Integer.parseInt(newsid));
			RList=replyDao.getReplyListByNewsId(Integer.parseInt(newsid));
			ReplyInfo replyInfo=new ReplyInfo();
			UserInfo user=(UserInfo) session.get("currentUser");
			replyInfo.setContent(reply.getContent());
			replyInfo.setNewsid(Integer.parseInt(newsid));
			replyInfo.setUserid(user.getId());
			replyInfo.setCreate_date(new Date(System.currentTimeMillis()));
			replyDao.add(replyInfo);
		}
		news=newsDao.getNewsInfo(Integer.parseInt(newsid));
		RList=replyDao.getReplyListByNewsId(Integer.parseInt(newsid));
		return "newsdetailsget_success";
	}
	
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
		
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}

	public List<NewsInfo> getNewsData() {
		return newsData;
	}

	public void setNewsData(List<NewsInfo> newsData) {
		this.newsData = newsData;
	}

	public NewsInfo getNews() {
		return news;
	}

	public void setNews(NewsInfo news) {
		this.news = news;
	}

	public String getNewsid() {
		return newsid;
	}

	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}

	public List<ReplyInfo> getRList() {
		return RList;
	}

	public void setRList(List<ReplyInfo> rList) {
		RList = rList;
	}

	public String getReurl() {
		return reurl;
	}

	public void setReurl(String reurl) {
		this.reurl = reurl;
	}

	public ReplyInfo getReply() {
		return reply;
	}

	public void setReply(ReplyInfo reply) {
		this.reply = reply;
	}

	
	
	
	

}

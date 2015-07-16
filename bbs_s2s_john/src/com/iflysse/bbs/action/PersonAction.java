package com.iflysse.bbs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.iflysse.bbs.dao.NewsDao;
import com.iflysse.bbs.dao.UserDao;
import com.iflysse.bbs.model.NewsInfo;
import com.iflysse.bbs.model.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller
public class PersonAction extends ActionSupport implements SessionAware  {

	
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private List<NewsInfo> newsList=null;
	private String title;
	private String title1;
	private  String newsid;
	private NewsInfo newsInfo;
	private String content;
	private String newPwd;
	
	@Resource
	private  NewsDao newsDao;
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	@Resource
	private  UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	
	public String newsList(){
		//NewsDao dao=new NewsDaoImpl();
		UserInfo user=(UserInfo) session.get("currentUser");
		if(title==null)
		{
			newsList=newsDao.getNewsList(user.getId());
		}
		else{
			newsList=newsDao.getNewsList(title,user.getId());
		}
		return "newsList_success";
	}

	public String delete(){
		newsDao.deleteById(Integer.parseInt(newsid));
		return this.newsList();
	}

	public String skipAddNews(){
		return "skipAddNews_success";
	}
	
	public String editNewGet(){
		newsInfo=newsDao.getNewsInfo(Integer.parseInt(newsid));
		return "editNewGet_success";
	}
	
	public String editNewPost(){
		NewsInfo news= null;
		if(newsid==null||newsid.equals(""))
		{
			
			UserInfo user =(UserInfo) session.get("currentUser");
			news=new NewsInfo();
			news.setContent(content);
			news.setTitle(title1);
			news.setCreate_date(new Date(System.currentTimeMillis()));
			news.setUserid(user.getId());
			newsDao.add(news);
		}
		else{
			news=newsDao.getNewsInfo(Integer.parseInt(newsid));
			news.setContent(content);
			news.setTitle(title1);
			news.setCreate_date(new Date(System.currentTimeMillis()));
			newsDao.edit(news);
		}
		return this.newsList();
	}
	
	public String editPwdGet(){
		return "editPwdGet_success";
	}
	
	public String editPwdPost(){
		UserInfo user=(UserInfo) session.get("currentUser");
		if(userDao.updatePwd(user.getId(), newPwd))
		{
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response=ServletActionContext.getResponse();
			String baseUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
			baseUrl+=request.getContextPath()+"/";
			String script="<script>window.parent.location.href='"+baseUrl+"all!cancel'</script>";
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(script);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return 	"editPwdPost_success";
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public List<NewsInfo> getNewsList() {
		return newsList;
	}


	public void setNewsList(List<NewsInfo> newsList) {
		this.newsList = newsList;
	}


	public String getNewsid() {
		return newsid;
	}


	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}


	public NewsInfo getNewsInfo() {
		return newsInfo;
	}


	public void setNewsInfo(NewsInfo newsInfo) {
		this.newsInfo = newsInfo;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getTitle1() {
		return title1;
	}


	public void setTitle1(String title1) {
		this.title1 = title1;
	}


	public String getNewPwd() {
		return newPwd;
	}


	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	
	





	
	
	
	
	
	
}

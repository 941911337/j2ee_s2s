package com.iflysse.bbs.action;

import com.opensymphony.xwork2.ActionSupport;

public class SkipAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String url;
	
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return url+"_success";
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
	

}

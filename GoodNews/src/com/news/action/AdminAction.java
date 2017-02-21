package com.news.action;

import java.util.List;
import java.util.Map;

import com.news.biz.AdminBiz;
import com.news.biz.NewsinfoBiz;
import com.news.entity.Admin;

public class AdminAction {
	private String loginName;
	private String loginPwd;
	public String getLoginname() {
		return loginName;
	}
	public void setLoginname(String loginname) {
		this.loginName = loginname;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	AdminBiz adminBiz;
	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}
	Map<String,Object> session;
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String validateLogin() throws Exception{
		Admin condition = new Admin();
		condition.setLoginName(loginName);
		condition.setLoginPwd(loginPwd);
		List list = adminBiz.login(condition);
		if(list.size()>0){
			session.put("admin", list.get(0));			
		}
		return "index"; 
	}
}

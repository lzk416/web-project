package com.restrant.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.restrant.biz.UserBiz;
import com.restrant.entity.Users;

public class UserAction extends ActionSupport implements RequestAware,SessionAware {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	private String loginName;
	private String loginPwd;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	//注册封装表单
	private Users user;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	UserBiz userBiz;

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	//登录验证
	public String validationLogin() throws Exception{
		List list;
		if ("userlogin".equals(type)) {
			Users condition = new Users();
			condition.setLoginName(loginName);
			condition.setLoginPwd(loginPwd);
			list = userBiz.login(condition);
			if (list.size()>0) {
				session.put("user",list.get(0));
			}
		}
		if ("loginPwd".equals(type)) {
			Users condition = new Users();
			condition.setLoginName(loginName);
			condition.setLoginPwd(loginPwd);
			list = userBiz.login(condition);
			if (list.size()>0) {
				session.put("admin",list.get(0));
			}
		}
		return "toShowMeal";
		
	}
	Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	Map<String, Object> request;

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
}

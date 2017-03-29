package com.netbank.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.netbank.biz.UserBiz;
import com.netbank.entity.Account;
import com.netbank.entity.Password;
import com.netbank.entity.Personinfo;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements RequestAware,SessionAware{
	@Resource private UserBiz userBiz;
	Map<String, Object> request;
	Map<String, Object> session;
	public void setSession(Map<String, Object> request) {
		this.request =request;
	}

	public void setRequest(Map<String, Object> session) {
		this.session=session;
	}
	private Account account;
	private Personinfo personinfo;
	private Password pwd;
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Personinfo getPersoninfo() {
		return personinfo;
	}

	public void setPersoninfo(Personinfo personinfo) {
		this.personinfo = personinfo;
	}
	//登录表单验证，根据用户名获取账号对象
	public void validateLogin(){
		Account a= userBiz.getAccount(account.getUsername());
		if (a==null) {
			this.addFieldError("username","用户名不存在");
		}else {
			if (!account.getPassword().equals(a.getPassword())) {
				this.addFieldError("username","密码不正确");
			}
		}
		account=a;
	}
	
	//执行页面用户登录请求
	public String login(){
		//personinfo对象在account是以为Set集合注入的，所有用iterator().next进行取值
		personinfo = (Personinfo) account.getPersoninfos().iterator().next();
		session.put("user",account);
		session.put("personinfo", personinfo);
		return "success";
	}
	//修改密码页面验证
	public void validateChangepwd(){
		//login() menthod--- session.put("user",account);
		account=(Account) session.get("user");
		if (! pwd.getOldpwd().equals(account.getPassword())) {
			this.addFieldError("pwd.oldpwd","密码不正确");
		}else if (! pwd.getNewpwd().equals(pwd.getConfirmpwd())) {
			this.addFieldError("pwd.oldpwd","两次密码不一致");
		}
	}
	//执行修改密码的请求
	public String changepwd(){
		account.setPassword(pwd.getNewpwd());
		if (userBiz.modifyAccount(account)) {
			session.put("user", account);
			request.put("message", "密码修改成功！");
			return "message";
		}
		request.put("message", "密码修改失败！");
		return "message";
	}
	
}

package com.netbank.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.netbank.biz.TransactionBiz;
import com.netbank.biz.UserBiz;
import com.netbank.entity.Account;
import com.netbank.entity.TransactionLog;
import com.opensymphony.xwork2.ActionSupport;

public class Transaction extends ActionSupport implements RequestAware,SessionAware{
	private UserBiz userBiz;

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	private TransactionBiz transactionBiz;

	public void setTransactionBiz(TransactionBiz transactionBiz) {
		this.transactionBiz = transactionBiz;
	}
	private Map<String, Object> request;
	private Map<String, Object> session;
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	private Account account;
	private TransactionLog log;

	public TransactionLog getLog() {
		return log;
	}

	public void setLog(TransactionLog log) {
		this.log = log;
	}
	public String deposit(){
		if (isEnable()) {
			log.setAccount(account);
			session.put("user", account);
			return isSuccess(transactionBiz.deposit(log));
		}
	}

	private String isSuccess(boolean flag) {
		if (flag) {
			request.put("message", "操作成功");
			return "message";
		}
		request.put("message","操作失败！<a href='javascript:histroy.go(-1)'>返回</a>" );
		return "message";
	}

	private boolean isEnable() {
		userBiz.reflush(account);
		if (account.getStatus().getName().equals("冻结")) {
			request.put("message", "对不起！你的账号被冻结了");
			return false;
		}
		return true;
	}
}

package com.netbank.biz.impl;

import com.netbank.biz.UserBiz;
import com.netbank.dao.UserDAO;
import com.netbank.entity.Account;

public class UserBizImpl implements UserBiz{
	UserDAO userDao;
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public Account getAccount(String username) {
		
		return userDao.getAccount(username);
	}

	public boolean modifyAccount(Account account) {
		return userDao.updateAccount(account);
	}
	public void reflush(Account account){
		return userDao.reflush(account);
	}
}

package com.netbank.biz.impl;

import com.netbank.biz.TransactionBiz;
import com.netbank.dao.TransactionDAO;
import com.netbank.dao.UserDAO;
import com.netbank.entity.Account;
import com.netbank.entity.TransactionLog;
import com.netbank.entity.TransactionType;

public class TransactionBizImpl implements TransactionBiz {
	private TransactionDAO transactionDao;
	


	public void setTransactionDao(TransactionDAO transactionDao) {
		this.transactionDao = transactionDao;
	}


	private UserDAO userDao;
	

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}


	public boolean deposit(TransactionLog log) {
		Account self= log.getAccount();
		self.setBalance(log.getAccount().getBalance()+log.getTrMoney());
		userDao.updateAccount(self);
		TransactionType type=transactionDao.getTransactionType("存款");
		log.setTransactionType(type);
		log.setOtherid(self.getAccountid());
		return transactionDao.addLog(log);
	}

}

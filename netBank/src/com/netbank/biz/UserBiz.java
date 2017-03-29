package com.netbank.biz;

import com.netbank.entity.Account;

public interface UserBiz {
	public Account getAccount(String username);
	public abstract boolean modifyAccount(Account account);
	public void reflush(Account account);
}

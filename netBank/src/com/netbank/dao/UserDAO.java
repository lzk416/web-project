package com.netbank.dao;

import com.netbank.entity.Account;

public interface UserDAO {
	public Account getAccount(String username);
	public boolean updateAccount(Account account);
	public void reflush(Account account);
}

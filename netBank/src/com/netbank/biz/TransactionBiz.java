package com.netbank.biz;

import com.netbank.entity.TransactionLog;

public interface TransactionBiz {
	public boolean deposit(TransactionLog log);
}

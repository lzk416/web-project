package com.netbank.dao;

import com.netbank.entity.TransactionLog;
import com.netbank.entity.TransactionType;

public interface TransactionDAO {
//根据交易类型名称获取交易类型对象
	public TransactionType getTransactionType(String name);
//向数据包transaction_log中添加交易记录
	public boolean addLog(TransactionLog log);
}

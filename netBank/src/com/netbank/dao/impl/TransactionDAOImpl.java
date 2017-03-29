package com.netbank.dao.impl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.netbank.dao.TransactionDAO;
import com.netbank.entity.TransactionLog;
import com.netbank.entity.TransactionType;


public class TransactionDAOImpl implements TransactionDAO{
	SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public TransactionType getTransactionType(String name) {
		Session session=sessionFactory.getCurrentSession();
		String hql ="from TransactionType t where t.name='"+name+"'";
		Query query = (Query) session.createQuery(hql);
		return (TransactionType) query.uniqueResult();
	}

	public boolean addLog(TransactionLog log) {
		Session session=sessionFactory.getCurrentSession();
		session.save(log);
		return true;
	}

}

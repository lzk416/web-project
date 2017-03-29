package com.netbank.dao.impl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.netbank.dao.UserDAO;
import com.netbank.entity.Account;

public class UserDAOImpl implements UserDAO{
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//根据username获取用户
	public Account getAccount(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Account where username='"+username+"'";
		Query query = session.createQuery(hql);
		return (Account) query.uniqueResult();
	}
	public boolean updateAccount(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(account);
		return true;
	}
	public void reflush(Account account){
		Session session=sessionFactory.getCurrentSession();
		session.refresh(account);
	}
}

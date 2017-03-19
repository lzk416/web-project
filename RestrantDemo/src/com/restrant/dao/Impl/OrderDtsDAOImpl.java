package com.restrant.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.restrant.dao.OrderDtsDao;
import com.restrant.entity.Orderdts;

public class OrderDtsDAOImpl implements OrderDtsDao{
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addOrderDts(Orderdts dts) {
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(dts);
	}
	
}

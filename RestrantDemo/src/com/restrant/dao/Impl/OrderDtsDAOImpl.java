package com.restrant.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.restrant.dao.OrderDtsDAO;
import com.restrant.entity.Orderdts;

public class OrderDtsDAOImpl implements OrderDtsDAO{
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addOrderDts(Orderdts dts) {
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(dts);
	}

	public List getOrderDtsByOid(int oid) {
		Session session =sessionFactory.getCurrentSession();
		Criteria c= session.createCriteria(Orderdts.class);
		c.add(Restrictions.eq("orders.oid", oid));
		return c.list();
	}
	
}

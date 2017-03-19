package com.restrant.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.restrant.dao.UserDAO;
import com.restrant.entity.Admin;
import com.restrant.entity.Users;

public class UserDAOImpl implements UserDAO{
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List search(Users condition) {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Users.class);
		Example example = Example.create(condition);
		c.add(example);
		list=c.list();
		return list;
	}

	public List search(Admin condition) {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Admin.class);
		Example example = Example.create(condition);
		c.add(example);
		list=c.list();
		return list;
	}
	
}

package com.netbank.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.netbank.dao.PersoninfoDAO;
import com.netbank.entity.Personinfo;

public class PersoninfoDAOImpl implements PersoninfoDAO {
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void modifyPersoninfo(Personinfo personinfo) {
		Session session=sessionFactory.getCurrentSession();
		session.update(personinfo);
	}
	
}

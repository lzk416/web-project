package com.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.news.dao.TopicDAO;
import com.news.entity.Topic;

public class TopicDAOImpl implements TopicDAO{
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List getALLTopics() {
		Session session =sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Topic.class);
		return c.list();
	}
}

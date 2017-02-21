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

	public void addTopic(Topic topic) {
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(topic);
	}

	public Topic getTopicById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Topic topic=(Topic)session.get(Topic.class, id);
		return topic;
	}
	public void deleteTopic(Topic topic) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(topic);
	}
	
	public int countTopics() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	//�޸�����
	public void updateTopic(Topic topic) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(topic);
	}
	
}

package com.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.news.dao.NewsinfoDAO;
import com.news.entity.Admin;
import com.news.entity.Newsinfo;

public class NewsinfoDAOImpl implements NewsinfoDAO {
	
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List getAllNewsinfoByPage(int page, int pageSize) {
		Session session =sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		c.setFirstResult(pageSize*(page-1));
		c.setMaxResults(pageSize);
		c.addOrder(Order.desc("createData"));
		return c.list();
	}

	public Integer getCountOfAllNewsinfo() {
		Session session =sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		return c.list().size();
	}

	public List getNewsinfoByConditionAndPage(Newsinfo condition, int page,
			int pageSize) {
		Session session =sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		if (condition!=null) {
			if (condition.getTopic()!=null&&(condition.getTopic().getId()!=null)) {
				c.add(Restrictions.eq("topic.id", condition.getTopic().getId()));
			}
			if (condition.getTitle()!=null&&!("".equals(condition.getTitle()))) {
				c.add(Restrictions.like("title", condition.getTitle(),MatchMode.ANYWHERE));
			}
		c.setFirstResult(pageSize*(page-1));
		c.setFirstResult(pageSize);
		c.addOrder(Order.desc("createDate"));
		
		}
		return c.list();
	}

	public Integer getCountOfNewsinfo(Newsinfo condition) {
		Session session =sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Newsinfo.class);
		if (condition!=null) {
			if (condition.getTopic()!=null&&(condition.getTopic().getId()!=null)) {
				c.add(Restrictions.eq("topic.id", condition.getTopic().getId()));
			}
			if (condition.getTitle()!=null&&!("".equals(condition.getTitle()))) {
				c.add(Restrictions.like("title", condition.getTitle(),MatchMode.ANYWHERE));
			}
		}
		return c.list().size();
	}

	public Newsinfo getNewsinfoById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Newsinfo newsinfo = (Newsinfo) session.get(Newsinfo.class, id);
		return newsinfo;
	}

	public void addNews(Newsinfo newsinfo) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(newsinfo);
		
	}
	//添加新闻的话，直接往session中都Newsinfo即可
	public void updateNews(Newsinfo newsinfo) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(newsinfo);
	}

	public void deleteNewsinfo(Newsinfo newsinfo) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(newsinfo);
	}
}

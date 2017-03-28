package com.restrant.dao.Impl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.restrant.dao.OrdersDAO;
import com.restrant.entity.Orders;

public class OrdersDAOImpl implements OrdersDAO{
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List getOrdersByUserId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c=session.createCriteria(Orders.class);
		c.add(Restrictions.eq("user.id", userId));
		return c.list();
	}

	public Orders getOrdersByOid(int oid) {
		Session session = sessionFactory.getCurrentSession();
		return (Orders) session.get(Order.class, oid);
	}

	public void deleteOrders(Orders orders) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(orders);
	}

	public List getAllOrders(int page) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Orders.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}

	public Integer getCountOfAllOrders() {
		Integer count =0;
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql="select count(o) from Orders o";
			Query query = session.createQuery(hql);
			count =Integer.parseInt(query.uniqueResult().toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List getOrdersByCondition(Orders condition, int page) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c =session.createCriteria(Orders.class);
		  if (condition!=null) {
			if ((condition.getOid()!=null)&&(condition.getOid()>0)) {
				c.add(Restrictions.eq("oid", condition.getOid()));
			}
			if (condition.getOrderState()!=null&&!condition.getOrderState().equals(" ")&&!condition.getOrderState().equals("全部")) {
				c.add(Restrictions.eq("orderState", condition.getOrderState()));
				
			}
		}
		  c.setFirstResult(6*(page-1));
		  c.setMaxResults(6);
		return c.list();
	}

	public Integer getCountOfOrders(Orders condition) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c =session.createCriteria(Orders.class);
		 if (condition!=null) {
				if ((condition.getOid()!=null)&&(condition.getOid()>0)) {
					c.add(Restrictions.eq("oid", condition.getOid()));
				}
				if (condition.getOrderState()!=null&&!condition.getOrderState().equals(" ")&&!condition.getOrderState().equals("全部")) {
					c.add(Restrictions.eq("orderState", condition.getOrderState()));
					
				}
			}
		 return  c.list().size();

	}

	public void updateOrders(Orders orders) {
		Session session =sessionFactory.getCurrentSession();
		session.update(orders);
	}
}

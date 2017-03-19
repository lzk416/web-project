package com.restrant.dao.Impl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.restrant.dao.MealDao;
import com.restrant.entity.Meal;

public class MealDaoImpl implements MealDao{
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//获取指定页显示的餐品列表
	public List getAllMeal(int page) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c =session.createCriteria(Meal.class);
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//统计所有餐品总数
	public Integer getCountOfALLMeal() {
		Integer count=null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria c= session.createCriteria(Meal.class);
			String hql = "selecy count(s) from Meal s ";
			Query query = session.createQuery(hql);
			count = Integer.parseInt(query.uniqueResult().toString());
		} catch (Exception e) {
		}
		return count;
	}
	//根据查询条件，获得指定页面显示的餐品列表
	public List getMealByCondition(Meal condition, int page) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c= session.createCriteria(Meal.class);
		if (condition!=null) {
			if (condition.getMealName()!=null&&condition.getMealName().equals("")) {
				c.add(Restrictions.like("mealName",condition.getMealName(),MatchMode.ANYWHERE));
			}
			if ((condition.getMealseries()!=null&&(condition.getMealseries().getSeriesId()!=null))) {
				c.add(Restrictions.like("mealseries.seriesId",condition.getMealName(),MatchMode.ANYWHERE));
			}
		}
		c.setFirstResult(6*(page-1));
		c.setMaxResults(6);
		return c.list();
	}
	//统计符合查询条件的餐品总数
	public Integer getCountOfMeal(Meal condition) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c= session.createCriteria(Meal.class);
		if (condition!=null) {
			//按菜名进行筛选
			if (condition.getMealName()!=null&&condition.getMealName().equals("")) {
				c.add(Restrictions.like("mealName",condition.getMealName(),MatchMode.ANYWHERE));
			}
			//按菜系进行筛选
			if ((condition.getMealseries()!=null&&(condition.getMealseries().getSeriesId()!=null))) {
				c.add(Restrictions.like("mealseries.seriesId",condition.getMealName(),MatchMode.ANYWHERE));
			}
		}
		return c.list().size();
	}
	public Meal getMealByMealId(int mealId){
		Session session= sessionFactory.getCurrentSession();
		return (Meal) session.get(Meal.class, mealId);
	}
}

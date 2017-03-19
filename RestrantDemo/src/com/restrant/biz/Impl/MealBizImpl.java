package com.restrant.biz.Impl;

import java.util.List;

import com.restrant.biz.MealBiz;
import com.restrant.dao.MealDao;
import com.restrant.entity.Meal;
import com.restrant.entity.Pager;

public class MealBizImpl implements MealBiz {
	MealDao mealDao;
	
	public void setMealDao(MealDao mealDao) {
		this.mealDao = mealDao;
	}

	public List getAllMeal(int page) {
		
		return mealDao.getAllMeal(page);
	}

	public Pager getPagerOfMeal() {
		int count = mealDao.getCountOfALLMeal();
		Pager pager = new Pager();
		pager.setPerPageRows(6);
		pager.setRowCount(count);
		return pager;
	}

	public List getMealByCondition(Meal condition, int page) {
		return mealDao.getMealByCondition(condition, page);
	}

	public Pager getPagerOfMeal(Meal condition) {
		int count = mealDao.getCountOfMeal(condition);
		Pager pager= new Pager();
		pager.setPerPageRows(6);
		pager.setRowCount(count);
		return pager;
	}
	public Meal getMealByMealId(int mealId) {
		return mealDao.getMealByMealId(mealId);
	}
	
}

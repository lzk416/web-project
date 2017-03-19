package com.restrant.biz.Impl;

import java.util.List;

import com.restrant.biz.MealSeriesBiz;
import com.restrant.dao.MealSeriesDAO;


public class MealSeriesBizImpl implements MealSeriesBiz {
	MealSeriesDAO mealSeriesDAO;
	
	public void setMealSeriesDAO(MealSeriesDAO mealSeriesDAO) {
		this.mealSeriesDAO = mealSeriesDAO;
	}

	public List getMealSeries() {
		return mealSeriesDAO.getMealSeries();
	}
	
}

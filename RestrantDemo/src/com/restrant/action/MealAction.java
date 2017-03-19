package com.restrant.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.restrant.biz.MealBiz;
import com.restrant.biz.MealSeriesBiz;
import com.restrant.entity.Meal;
/*
 * RequestAware 定义在request域进行请求
 */
import com.restrant.entity.Pager;
public class MealAction  extends ActionSupport implements RequestAware{
	private Meal meal;

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}
	MealBiz mealBiz;

	public void setMealBiz(MealBiz mealBiz) {
		this.mealBiz = mealBiz;
	}
	MealSeriesBiz mealSeriesBiz;

	public void setMealSeriesBiz(MealSeriesBiz mealSeriesBiz) {
		this.mealSeriesBiz = mealSeriesBiz;
	}
	private Pager pager;

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	Map<String, Object> request;

	public void setRequest(Map<String, Object> arg0) {
		this.request=request;
	}
	
	public String toShowMeal(){
		int curPage=1;
		if (pager!=null) {
			curPage=pager.getCurPage();
		}
		List mealList = null;
		if (meal!=null) {
			mealList = mealBiz.getMealByCondition(meal, curPage);
			pager = mealBiz.getPagerOfMeal(meal);
			if ((meal.getMealseries()!=null)&&(meal.getMealseries().getSeriesId()!=null)) {
				request.put("seriesId", new Integer(meal.getMealseries().getSeriesId()));
			}
			if ((meal.getMealName()!=null)&&!meal.getMealName().equals("")) {
				request.put("mealName", meal.getMealName());
			}
		}else {
			mealList = mealBiz.getAllMeal(curPage);
			pager=mealBiz.getPagerOfMeal();
		}
		pager.setCurPage(curPage);
		request.put("mealList", mealList);
		List mealSeriesList = mealSeriesBiz.getMealSeries();
		request.put("mealSeriesList", mealSeriesList);
		return "toShowMeal";
	}
	
}

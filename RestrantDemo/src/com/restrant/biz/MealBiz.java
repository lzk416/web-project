package com.restrant.biz;

import java.util.List;

import com.restrant.entity.Meal;
import com.restrant.entity.Pager;

public interface MealBiz {
	public List getAllMeal(int page);
	public Pager getPagerOfMeal();
	public List getMealByCondition(Meal condition,int page);
	public Pager getPagerOfMeal(Meal condition);
	public Meal getMealByMealId(int mealId);
	public void addMeal(Meal meal);
	public void updateMeal(Meal meal);
	public void deleteMeal(int mealId);
}

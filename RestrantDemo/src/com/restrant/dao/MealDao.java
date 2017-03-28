package com.restrant.dao;

import java.util.List;

import com.restrant.entity.Meal;

public interface MealDAO {
	public List getAllMeal(int page);
	public Integer getCountOfALLMeal();
	public List getMealByCondition(Meal condition,int page);
	public Integer getCountOfMeal(Meal condition);
	public Meal getMealByMealId(int mealId);
	public void addMeal(Meal meal);
	public void updateMeal(Meal meal);
	public void deleteMeal(Meal meal);
}

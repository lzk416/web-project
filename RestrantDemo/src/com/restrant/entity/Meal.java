package com.restrant.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Meal entity. @author MyEclipse Persistence Tools
 */

public class Meal implements java.io.Serializable {

	// Fields

	private Integer mealId;
	private String mealName;
	private String mealSummarize;
	private String mealDescription;
	private Mealseries mealseries;
	private Double mealPrice;
	private String mealImage;
	private Set ordertses = new HashSet(0);
	
	public Mealseries getMealseries() {
		return mealseries;
	}

	public void setMealseries(Mealseries mealseries) {
		this.mealseries = mealseries;
	}

	public Set getOrdertses() {
		return ordertses;
	}

	public void setOrdertses(Set ordertses) {
		this.ordertses = ordertses;
	}
	// Constructors

	/** default constructor */
	public Meal() {
	}

	/** full constructor */

	// Property accessors

	public Integer getMealId() {
		return this.mealId;
	}

	public Meal(Integer mealId, String mealName, String mealSummarize,
			String mealDescription, Mealseries mealseries, Double mealPrice,
			String mealImage, Set ordertses) {
		super();
		this.mealId = mealId;
		this.mealName = mealName;
		this.mealSummarize = mealSummarize;
		this.mealDescription = mealDescription;
		this.mealseries = mealseries;
		this.mealPrice = mealPrice;
		this.mealImage = mealImage;
		this.ordertses = ordertses;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public String getMealName() {
		return this.mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getMealSummarize() {
		return this.mealSummarize;
	}

	public void setMealSummarize(String mealSummarize) {
		this.mealSummarize = mealSummarize;
	}

	public String getMealDescription() {
		return this.mealDescription;
	}

	public void setMealDescription(String mealDescription) {
		this.mealDescription = mealDescription;
	}

	public Double getMealPrice() {
		return this.mealPrice;
	}

	public void setMealPrice(Double mealPrice) {
		this.mealPrice = mealPrice;
	}

	public String getMealImage() {
		return this.mealImage;
	}

	public void setMealImage(String mealImage) {
		this.mealImage = mealImage;
	}

}
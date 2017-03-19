package com.restrant.entity;

import org.hibernate.criterion.Order;

/**
 * Orderdts entity. @author MyEclipse Persistence Tools
 */

public class Orderdts implements java.io.Serializable {

	// Fields

	private Integer odid;
	private Order orders;
	private Double mealPrice;
	private Integer mealCount;
	private Meal meal;
	

	// Constructors

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	/** default constructor */
	public Orderdts() {
	}

	/** full constructor */
	public Orderdts( Double mealPrice,
			Integer mealCount) {
		this.mealPrice = mealPrice;
		this.mealCount = mealCount;
	}

	// Property accessors

	public Integer getOdid() {
		return this.odid;
	}

	public void setOdid(Integer odid) {
		this.odid = odid;
	}


	public Double getMealPrice() {
		return this.mealPrice;
	}

	public void setMealPrice(Double mealPrice) {
		this.mealPrice = mealPrice;
	}

	public Integer getMealCount() {
		return this.mealCount;
	}

	public void setMealCount(Integer mealCount) {
		this.mealCount = mealCount;
	}

}
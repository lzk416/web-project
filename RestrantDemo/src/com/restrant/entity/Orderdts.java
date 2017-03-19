package com.restrant.entity;


/**
 * Orderdts entity. @author MyEclipse Persistence Tools
 */

public class Orderdts implements java.io.Serializable {

	// Fields

	private Integer odid;
	private Orders orders;
	private Double mealPrice;
	private Integer mealCount;
	private Meal meal;
	

	// Constructors

	

	public Meal getMeal() {
		return meal;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
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
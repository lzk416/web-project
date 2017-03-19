package com.restrant.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Mealseries entity. @author MyEclipse Persistence Tools
 */

public class Mealseries implements java.io.Serializable {

	// Fields

	private Integer seriesId;
	private String seriesName;
	private Set meals=new HashSet(0);
	
	// Constructors

	/** default constructor */
	public Mealseries() {
	}

	public Set getMeals() {
		return meals;
	}

	public void setMeals(Set meals) {
		this.meals = meals;
	}

	/** full constructor */
	public Mealseries(String seriesName) {
		this.seriesName = seriesName;
	}

	// Property accessors

	public Integer getSeriesId() {
		return this.seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public String getSeriesName() {
		return this.seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

}
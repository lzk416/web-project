package com.restrant.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Timestamp orderTime;
	private String orderState;
	private Double orderPrice;
	private Users users;
	private Set orderdtses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	public Set getOrderdtses() {
		return orderdtses;
	}

	public void setOrderdtses(Set orderdtses) {
		this.orderdtses = orderdtses;
	}

	/** full constructor */
	public Orders(Integer userId, Timestamp orderTime, String orderState,
			Double orderPrice) {
		this.orderTime = orderTime;
		this.orderState = orderState;
		this.orderPrice = orderPrice;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}


	public Timestamp getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public Double getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

}
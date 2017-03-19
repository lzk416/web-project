package com.restrant.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer oid;
	private String orderState;
	private Double orderPrice;
	private Date orderTime;
	private Users users;
	private Set orderdtses = new HashSet(0);

	// Constructors
	
	/** default constructor */
	public Orders() {
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
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
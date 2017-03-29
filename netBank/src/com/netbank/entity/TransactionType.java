package com.netbank.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TransactionType entity. @author MyEclipse Persistence Tools
 */

public class TransactionType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set transactionLogs = new HashSet(0);
	
	
	public TransactionType(String name, Set transactionLogs) {
		super();
		this.name = name;
		this.transactionLogs = transactionLogs;
	}
	// Constructors
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getTransactionLogs() {
		return transactionLogs;
	}
	public void setTransactionLogs(Set transactionLogs) {
		this.transactionLogs = transactionLogs;
	}

	/** default constructor */


}
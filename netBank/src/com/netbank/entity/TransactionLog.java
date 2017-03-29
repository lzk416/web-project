package com.netbank.entity;

/**
 * TransactionLog entity. @author MyEclipse Persistence Tools
 */

public class TransactionLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer otherid;
	private Double trMoney;
	private String datetime;
	private Account account;
	private TransactionType transactionType;
	// Constructors
	
	/** default constructor */
	public TransactionLog() {
	}

	public TransactionLog(Integer otherid, Double trMoney, String datetime,
			Account account, TransactionType transactionType) {
		super();
		this.otherid = otherid;
		this.trMoney = trMoney;
		this.datetime = datetime;
		this.account = account;
		this.transactionType = transactionType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOtherid() {
		return otherid;
	}

	public void setOtherid(Integer otherid) {
		this.otherid = otherid;
	}

	public Double getTrMoney() {
		return trMoney;
	}

	public void setTrMoney(Double trMoney) {
		this.trMoney = trMoney;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	

}
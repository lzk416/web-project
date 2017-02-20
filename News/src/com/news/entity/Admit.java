package com.news.entity;

/**
 * Admit entity. @author MyEclipse Persistence Tools
 */

public class Admit implements java.io.Serializable {

	// Fields

	private Integer id;
	private String loginName;
	private String loginPwd;

	// Constructors

	/** default constructor */
	public Admit() {
	}

	/** full constructor */
	public Admit(String loginName, String loginPwd) {
		this.loginName = loginName;
		this.loginPwd = loginPwd;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

}
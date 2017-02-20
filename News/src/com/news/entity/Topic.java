package com.news.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set newsinfo = new HashSet(0);
	// Constructors

	public Set getNewsinfo() {
		return newsinfo;
	}

	public void setNewsinfo(Set newsinfo) {
		this.newsinfo = newsinfo;
	}

	/** default constructor */
	public Topic() {
	}

	/** full constructor */
	public Topic(String name) {
		this.name = name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
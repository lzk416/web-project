package com.news.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Newsinfo entity. @author MyEclipse Persistence Tools
 */

public class Newsinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String author;
	private Date createDate;
	private String content;
	private String summary;
	private Topic topic; //用于一对多关联

	// Constructors

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	/** default constructor */
	public Newsinfo() {
	}

	/** full constructor */
	public Newsinfo(String title, String author, Timestamp createDate,
			String content, String summary, Integer tid) {
		this.title = title;
		this.author = author;
		this.createDate = createDate;
		this.content = content;
		this.summary = summary;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
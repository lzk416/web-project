package com.news.biz.impl;

import java.util.List;

import com.news.biz.NewsinfoBiz;
import com.news.dao.NewsinfoDAO;
import com.news.entity.Newsinfo;
import com.news.entity.Pager;

public class NewsinfoBizImpl implements NewsinfoBiz {
	NewsinfoDAO newsinfoDAO;
	
	public void setNewsinfoDAO(NewsinfoDAO newsinfoDAO) {
		this.newsinfoDAO = newsinfoDAO;
	}

	public List getAllNewsinfoByPage(int page, int pageSize) {
		
		return null;
	}

	public List getNewsinfoByConditionAndPage(Newsinfo condition, int page,
			int pageSize) {
		return null;
	}

	public Pager getPagerOfAllNewsinfo(int pageSize) {
		return null;
	}

	public Pager getPagerOfNewsinfo(Newsinfo condition, int pageSize) {
		return null;
	}

}

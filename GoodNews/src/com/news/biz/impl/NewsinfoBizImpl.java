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
	//获取指定页码的新闻列表
	public List getAllNewsinfoByPage(int page, int pageSize) {
		return newsinfoDAO.getAllNewsinfoByPage(page, pageSize);
	}
	//根据主题编号，新闻标题等条件指定页码获取新闻列表
	public List getNewsinfoByConditionAndPage(Newsinfo condition, int page,
			int pageSize) {
		return newsinfoDAO.getNewsinfoByConditionAndPage(condition, page, pageSize);
	}
	//获取所有新闻的数量，用来初始化分页类Pager对象
	public Pager getPagerOfAllNewsinfo(int pageSize) {
		int count = newsinfoDAO.getCountOfAllNewsinfo();
		Pager pager = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		return pager;
	}
	//根据主题编号，新闻标题等条件指定页码获取新闻数量，并初始化分页类的page对象
	public Pager getPagerOfNewsinfo(Newsinfo condition, int pageSize) {
		int count = newsinfoDAO.getCountOfNewsinfo(condition);
		Pager pager = new Pager();
		pager.setPerPageRows(pageSize);
		pager.setRowCount(count);
		return pager;
	}
	public Newsinfo getNewsinfoById(int id) {

		return newsinfoDAO.getNewsinfoById(id);
	}
	public void addNews(Newsinfo newsinfo) {
		newsinfoDAO.addNews(newsinfo);
		
	}
	public void updateNews(Newsinfo newsinfo) {
		newsinfoDAO.updateNews(newsinfo);
	}
	public void deleteNews(int id) {
		Newsinfo newsinfo = newsinfoDAO.getNewsinfoById(id);
		newsinfoDAO.deleteNewsinfo(newsinfo);
	}
}

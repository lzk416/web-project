package com.news.biz;

import java.util.List;

import com.news.entity.Newsinfo;
import com.news.entity.Pager;

public interface NewsinfoBiz {
	public List getAllNewsinfoByPage(int page,int pageSize); 
	public List getNewsinfoByConditionAndPage(Newsinfo condition,int page,int pageSize);
	public Pager getPagerOfAllNewsinfo(int pageSize);
	public Pager getPagerOfNewsinfo(Newsinfo condition,int pageSize);
	public Newsinfo getNewsinfoById(int id);
	public void addNews(Newsinfo newsinfo);
	public void updateNews(Newsinfo newsinfo);
	public void deleteNews(int id);
}

package com.news.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.news.biz.NewsinfoBiz;
import com.news.biz.TopicBiz;
import com.news.entity.Admin;
import com.news.entity.Newsinfo;
import com.news.entity.Pager;
import com.news.entity.Topic;
import com.opensymphony.xwork2.ActionSupport;

public class NewsinfoAction extends ActionSupport implements RequestAware,SessionAware{
	//命名一个id用于封装超链接传递过来的新闻编号
	int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	Newsinfo newsinfo;

	public Newsinfo getNewsinfo() {
		return newsinfo;
	}

	public void setNewsinfo(Newsinfo newsinfo) {
		this.newsinfo = newsinfo;
	}
	TopicBiz topicBiz;

	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}
	//newsinfoBiz这个就是控制反转了，在applicationContext中设置的
	//如果是有注入了其他的，在property就写它，不然的话就写sessionFactory
	NewsinfoBiz newsinfoBiz;

	public void setNewsinfoBiz(NewsinfoBiz newsinfoBiz) {
		this.newsinfoBiz = newsinfoBiz;
	}
	private Pager pager;

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	Map<String, Object> request;
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String index() throws Exception{
		int curPage=1;
		if (pager!=null) 
		curPage=pager.getCurPage();
		List newsinfoList=null;
		if (newsinfoList==null) {
			newsinfoList = newsinfoBiz.getAllNewsinfoByPage(curPage, 10);
			pager =newsinfoBiz.getPagerOfAllNewsinfo(10);
		}else {
			newsinfoList = newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo, 10);
		}
		pager.setCurPage(curPage);
		request.put("newsinfoList", newsinfoList);
		List topicList = topicBiz.getALLTopics();
		request.put("topicList", topicList);
		return "index";
	}
	//需要在struts中配置action
	public String indexsidebar() throws Exception{
		Newsinfo condition = new Newsinfo();
		Topic topic = new Topic();
		topic.setId(1);
		condition.setTopic(topic);
		List domesticNewsList = newsinfoBiz.getNewsinfoByConditionAndPage(condition, 1, 5);
		topic.setId(2);
		condition.setTopic(topic);
		List internationalNewsList = newsinfoBiz.getNewsinfoByConditionAndPage(condition, 1, 5);
		//在request域设置国内和国外新闻。
		request.put("domesticNewsList", domesticNewsList);
		request.put("internationalNewsList", internationalNewsList);
		return "index_sidebar";
	}
	//此方法用于转到新闻浏览页面
	public String newsread() throws Exception{
		Newsinfo  newsinfo = newsinfoBiz.getNewsinfoById(id); //根据新闻编号获取新闻，在前面已经设定好了id属性。
		request.put("newsinfo", newsinfo);
		Newsinfo condition = new Newsinfo();
		Topic topic = new Topic();
		topic.setId(1);
		condition.setTopic(topic);
		List domesticNewsLis = newsinfoBiz.getNewsinfoByConditionAndPage(condition, 1, 5);
		topic.setId(2);
		condition.setTopic(topic);
		List internationalNewsLis = newsinfoBiz.getNewsinfoByConditionAndPage(condition, 1, 5);
		request.put("domesticNewsLis",domesticNewsLis);
		request.put("internationalNewsLis",internationalNewsLis);
		List topicList = topicBiz.getALLTopics();
		request.put("topicList", topicList);
		return "news_read";
	}
	public String admin() throws Exception {
		List newsinfoList=null;
		int curPage=1;
		if(pager!=null)
			curPage=pager.getCurPage();
		if(newsinfo==null){
			newsinfoList=newsinfoBiz.getAllNewsinfoByPage(curPage,10);
			pager=newsinfoBiz.getPagerOfAllNewsinfo(10);
		}else{
			newsinfoList=newsinfoBiz.getNewsinfoByConditionAndPage(newsinfo, curPage, 10);
			pager=newsinfoBiz.getPagerOfNewsinfo(newsinfo,10);			
		}
		pager.setCurPage(curPage);
		request.put("newsinfoList", newsinfoList);
		List topicList=topicBiz.getALLTopics();
		request.put("topicList", topicList);
		return "admin";
	}
	
	public String toNewsAdd() throws Exception{
		List topicList = topicBiz.getALLTopics();
		request.put("topicList", topicList);
		return"news_add";
	}
	public String doNewsAdd() throws Exception{
		Admin admin = (Admin) session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		//进行新闻添加的操作
		newsinfoBiz.addNews(newsinfo);
		//完成之后返回主页admin
		return "admin";
	}
	//这个是从哪个修改按钮到哪个修改的框框页面。
	public String toNewsModify() throws Exception{
		Newsinfo newsinfo = newsinfoBiz.getNewsinfoById(id);
		request.put("newsinfo", newsinfo);
		List topicList = topicBiz.getALLTopics();
		request.put("topicList",topicList);
		return "news_modify";
	}
	//session已经在上面的Map(String,Object)中定义了。
	public String doNewsModify() throws Exception{
		Admin admin = (Admin) session.get("admin");
		newsinfo.setAuthor(admin.getLoginName());
		newsinfo.setCreateDate(new Date());
		newsinfoBiz.updateNews(newsinfo);
		return "admin";
	}
	
	public String deleteNews(int id){
		newsinfoBiz.deleteNews(id);
		return "admin";
	}
}

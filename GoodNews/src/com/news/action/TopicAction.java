package com.news.action;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import com.news.biz.TopicBiz;
import com.news.entity.Topic;
import com.opensymphony.xwork2.ActionSupport;

public class TopicAction extends ActionSupport implements RequestAware {
	
	TopicBiz topicBiz;
	public void setTopicBiz(TopicBiz topicBiz) {
		this.topicBiz = topicBiz;
	}	
	
	Map<String, Object> request;
	public void setRequest(Map<String, Object> request) {
		this.request=request;		
	}
	
	Topic topic;	
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String addtopic() throws Exception {
		topicBiz.addTopic(topic);
		return "admin";
	}
	
	
	public String topiclist() throws Exception {
		List topicList=topicBiz.getALLTopics();
		request.put("topicList", topicList);
		return "topic_list";
	}
	
	//ɾ������
	public String deletetopic() throws Exception {
		topicBiz.deleteTopic(topic.getId());
		return "topiclist";
	}
	
	public String toTopicModify() throws Exception {
		Topic modifyTopic=topicBiz.getTopicById(topic.getId());
		request.put("modifyTopic", modifyTopic);
		return "topic_modify";
	}
	
	public String doTopicModify() throws Exception {
		topicBiz.updateTopic(topic);
		return "topiclist";
	}
	
}

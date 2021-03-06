package com.news.biz.impl;

import java.util.List;

import com.news.dao.NewsinfoDAO;
import com.news.dao.TopicDAO;
import com.news.entity.Topic;

public class TopicBizImpl implements TopicDAO{
	TopicDAO topicDAO;
	public void setTopicDAO(TopicDAO topicDAO) {
		this.topicDAO = topicDAO;
	}
	//获取所有的主题
	public List getALLTopics() {
		return topicDAO.getALLTopics();
	}
	public void addTopic(Topic topic) {
		topicDAO.addTopic(topic);
	}
}

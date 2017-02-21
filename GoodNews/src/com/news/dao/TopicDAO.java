package com.news.dao;

import java.util.List;

import com.news.entity.Topic;

public interface TopicDAO {
	public List getALLTopics();
	public void addTopic(Topic topic);
	public Topic getTopicById(int id);	
	
}

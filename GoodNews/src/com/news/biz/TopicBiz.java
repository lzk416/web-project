package com.news.biz;

import java.util.List;

import com.news.entity.Topic;

public interface TopicBiz {
	public List getALLTopics();
	public void addTopic(Topic topic);
}

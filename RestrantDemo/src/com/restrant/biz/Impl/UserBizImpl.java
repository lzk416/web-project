package com.restrant.biz.Impl;

import java.util.List;

import com.restrant.biz.UserBiz;
import com.restrant.dao.UserDAO;
import com.restrant.entity.Admin;
import com.restrant.entity.Users;

public class UserBizImpl implements UserBiz{
	UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List login(Users condition) {
		
		return userDAO.search(condition);
	}

	public List login(Admin condition) {
		return userDAO.search(condition);
	}
	
}

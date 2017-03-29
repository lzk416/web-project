package com.netbank.biz.impl;

import com.netbank.biz.PersoninfoBiz;
import com.netbank.dao.PersoninfoDAO;
import com.netbank.dao.UserDAO;
import com.netbank.entity.Personinfo;

public class PersoninfoBizImpl implements PersoninfoBiz {
	PersoninfoDAO personinfoDao;
	
	public void setPersoninfoDao(PersoninfoDAO personinfoDao) {
		this.personinfoDao = personinfoDao;
	}

	UserDAO userDao;
	
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}


	public boolean modifyPersoninfo(Personinfo personinfo) {
		personinfoDao.modifyPersoninfo(personinfo);
		return true;
	}
	
}

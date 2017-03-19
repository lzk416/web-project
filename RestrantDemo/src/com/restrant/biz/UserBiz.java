package com.restrant.biz;

import java.util.List;

import com.restrant.entity.Admin;
import com.restrant.entity.Users;

public interface UserBiz {
	public List login(Users condition);
	public List login(Admin condition);
}

package com.restrant.dao;

import java.util.List;

import com.restrant.entity.Admin;
import com.restrant.entity.Users;

public interface UserDAO {
	public List search(Users condition);
	public List search(Admin condition);
}

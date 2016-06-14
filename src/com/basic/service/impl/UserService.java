package com.basic.service.impl;

import java.util.List;

import com.basic.base.BaseService;
import com.basic.dao.IUserDao;
import com.basic.pojo.User;
import com.basic.service.IUserService;

public class UserService extends BaseService implements IUserService {
	
	private IUserDao userDao;
	
	public User findOneByEmail(String email) {
		return userDao.findOneByEmail(email);
	}
	
	public IUserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(IUserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}
	
}

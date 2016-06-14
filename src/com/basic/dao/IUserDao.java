package com.basic.dao;

import java.util.List;

import com.basic.base.IBaseDao;
import com.basic.pojo.User;
import com.basic.util.Page;

public interface IUserDao extends IBaseDao<User, Integer> {
	public User findOneByEmail(String email);
}

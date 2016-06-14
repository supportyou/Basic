package com.basic.service;

import java.util.List;

import com.basic.base.IBaseService;
import com.basic.pojo.User;

public interface IUserService extends IBaseService {
	public User findOneByEmail(String email);
}

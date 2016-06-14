package com.basic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.basic.base.BaseDao;
import com.basic.dao.IUserDao;
import com.basic.pojo.User;
import com.basic.util.ChkUtil;
import com.basic.util.Page;

public class UserDao extends BaseDao<User, Integer> implements IUserDao {
	
	public User findOneByEmail(String email) {

		String hql="from User u where u.email=:email";
		
		Query query = super.getSession().createQuery(hql);
		if (email != null) {
			query.setString("email", email);
		}

		return (User)query.setMaxResults(1).uniqueResult();
	}

}

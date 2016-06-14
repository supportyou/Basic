package com.basic.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.basic.util.Page;

public abstract class BaseService<T, ID extends Serializable> implements IBaseService<T, ID> {
	private IBaseDao<T, ID> baseDao;
	
	
	public void save(T t) {
		baseDao.save(t);
	}
	public void saveOrUpdate(T t) {
		baseDao.saveOrUpdate(t);
	}
	public void update(T t) {
		baseDao.update(t);
	}
	public void delete(T t) {
		baseDao.delete(t);
	}
	public T get(ID id) {
		return baseDao.get(id);
	}
	public T load(ID id) {
		return baseDao.load(id);
	}

	public T findOne(ID id) {
		return baseDao.findOne(id);
	}
	public List<T> findAll(T t) {
		return baseDao.findAll(t);
	}
	
	public List<T> findAllByHQL(String hqlString) {
		return baseDao.findAllByHQL(hqlString);
	}
	public List<T> findAllBySQL(String sqlString) {
		return baseDao.findAllBySQL(sqlString);
	}
	
	public Page<T> findAllByPager(int pageSize, int pageNo) {
		return baseDao.findAllByPager(pageSize, pageNo);
	}
	public Page<T> findAllByPager(int pageSize, int pageNo, String orderByProperty, boolean desc) {
		return baseDao.findAllByPager(pageSize, pageNo, orderByProperty, desc);
	}
	
	public void deleteAll(Collection<T> ts) {
		baseDao.deleteAll(ts);
	}
	
	
	public IBaseDao getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

}

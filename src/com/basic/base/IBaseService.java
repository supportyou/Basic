package com.basic.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.basic.util.Page;

public interface IBaseService<T, ID extends Serializable> {
	
	public abstract void save(T t);
	public abstract void saveOrUpdate(T t);
	public abstract void update(T t);
	public abstract void delete(T t);
	public abstract T get(ID id);
	public abstract T load(ID id);

	public abstract T findOne(ID id);
	public abstract List<T> findAll(T t);
	
	public abstract List<T> findAllByHQL(String hqlString);
	public abstract List<T> findAllBySQL(String sqlString);
	
	public abstract Page<T> findAllByPager(int pageSize, int pageNo);
	public abstract Page<T> findAllByPager(int pageSize, int pageNo, String orderByProperty, boolean desc);
	
	public abstract void deleteAll(Collection<T> ts);
	
}
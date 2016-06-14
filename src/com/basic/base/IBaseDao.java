package com.basic.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.basic.util.Page;

public interface IBaseDao<T, ID extends Serializable> {
	
	public abstract void save(T t) throws DataAccessException;
	public abstract void saveOrUpdate(T t) throws DataAccessException;
	public abstract void update(T t) throws DataAccessException;
	public abstract void delete(T t) throws DataAccessException;
	public abstract T get(ID id) throws DataAccessException;
	public abstract T load(ID id) throws DataAccessException;

	public abstract T findOne(ID id) throws DataAccessException;
	public abstract List<T> findAll(T t) throws DataAccessException;
	
	public abstract List<T> findAllByHQL(String hqlString) throws DataAccessException;
	public abstract List<T> findAllBySQL(String sqlString) throws DataAccessException;
	
	public abstract Page<T> findAllByPager(int pageSize, int pageNo);
	public abstract Page<T> findAllByPager(int pageSize, int pageNo, String orderByProperty, boolean desc);
	
	public abstract void deleteAll(Collection<T> ts) throws DataAccessException;
	
}
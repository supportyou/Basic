package com.basic.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.dao.DataAccessException;

import com.basic.test.Test;
import com.basic.util.Page;

public class BaseDao<T, ID extends Serializable> implements IBaseDao<T, ID> {

	private SessionFactory sessionFactory;
	protected Class<T> clazz;
	
	protected String oid;

	public BaseDao() {
		//this.clazz=this.getEntityClass();
	}
	
	protected Class getEntityClass() {
		if (clazz == null) {
			clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		return clazz;
	}

	public void save(T t) throws DataAccessException {
		this.getSession().save(t);
	}
	public void saveOrUpdate(T t) throws DataAccessException {
		this.getSession().saveOrUpdate(t);
	}
	public void update(T t) throws DataAccessException {
		this.getSession().update(t);
	}
	public void delete(T t) throws DataAccessException {
		this.getSession().delete(t);
	}
	public T get(ID id) throws DataAccessException {
		T load = (T) this.getSession().get(getEntityClass(), id);
		return load;
	}
	public T load(ID id) throws DataAccessException {
		T load = (T) this.getSession().load(getEntityClass(), id);
		return load;
	}
	
	
	public T findOne(ID id) throws DataAccessException {
		T findone = (T) this.getSession().get(getEntityClass(), id);
		return findone;
	}
	public List<T> findAll(T t)throws DataAccessException {
		Criteria criteria = this.getSession().createCriteria(getEntityClass());
		return criteria.list();
	}
	
	
	public List<T> findAllByHQL(String hqlString)throws DataAccessException {
		return this.getSession().createQuery(hqlString).list();
	}
	public List<T> findAllBySQL(String sqlString) throws DataAccessException {
		return this.getSession().createSQLQuery(sqlString).list();
	}
	
	public Page<T> findAllByPager(int pageSize, int pageNo) {
		Page<T> page = new Page<T>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		oid=this.getId();

		StringBuilder sb = new StringBuilder();
		sb.append("select count(").append(oid).append(") from ").append(getEntityClass().getSimpleName());
			Long count = (Long)this.getSession().createQuery(sb.toString()).uniqueResult();
			
			if(count !=null && count.intValue() > 0){
				page.setTotalElements(count.intValue());
				
				List<T> list = createCriteria()
								   .setMaxResults(pageSize)
								   .setFirstResult((pageNo - 1)*pageSize)
								   .list();
				page.setContent(list);
			}
		
		return page;
	}
	
	public Page<T> findAllByPager(int pageSize, int pageNo, String orderByProperty, boolean desc){
		Page<T> page = new Page<T>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		
		oid=this.getId();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select count(").append(oid).append(") from ").append(getEntityClass().getSimpleName());
			Long count = (Long)this.getSession().createQuery(sb.toString()).uniqueResult();
			
			if(count !=null && count.intValue() > 0){
				page.setTotalElements(count.intValue());
				
				Criteria c = createCriteria();

				if(desc){
					c.addOrder(Order.desc(orderByProperty));
				}else{
					c.addOrder(Order.asc(orderByProperty));
				}
				List<T> list = c.setMaxResults(pageSize)
								   .setFirstResult((pageNo - 1)*pageSize)
								   .list();
				
				page.setContent(list);
			}
		return page;
	}
	
	public void deleteAll(Collection<T> ts) throws DataAccessException {
		for(Object t : ts) {
			this.getSession().delete(t);
		}
	}
	
	
	protected Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(getEntityClass());
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}
	
	protected String getId(){
		return getSessionFactory().getClassMetadata(getEntityClass()).getIdentifierPropertyName();
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}

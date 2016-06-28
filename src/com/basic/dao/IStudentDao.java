package com.basic.dao;

import java.util.List;

import com.basic.base.IBaseDao;
import com.basic.pojo.Student;
import com.basic.util.Page;

public interface IStudentDao extends IBaseDao<Student, Integer> {
	
	//public void save(Student student);
	//public void update(Student student);
	//public void delete(Student student);
	
	//public Student findOne(int id);
	//public List<Student> findAll(Student student);
	
	//public Page<Student> findAllByPager(int pageSize, int pageNo);
	//public Page<Student> findAllByPager(int pageSize, int pageNo, String orderByProperty, boolean desc);
	
	public void saveList(List<Student> sList);
	
}

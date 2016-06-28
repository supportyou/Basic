package com.basic.service.impl;

import java.util.List;

import com.basic.base.BaseService;
import com.basic.dao.IStudentDao;
import com.basic.service.IStudentService;

import com.basic.pojo.Student;

public class StudentService extends BaseService implements IStudentService {
	
	private IStudentDao studentDao;

	//public void save(Student student) {
		//studentDao.save(student);
	//}
	
	//public void update(Student student) {
		//studentDao.update(student);
	//}
	
	//public void delete(Student student) {
		//studentDao.delete(student);
	//}
	
	//public Student findOne(int id) {
		//return studentDao.findOne(id);
	//}
	
	//public List<Student> findAll(Student student) {
		//return studentDao.findAll(student);
	//}
	
	//public Page<Student> findAllByPager(int pageSize, int pageNo) {
		//return studentDao.findAllByPager(pageSize, pageNo);
	//}
	
	//public Page<Student> findAllByPager(int pageSize, int pageNo, String orderByProperty, boolean desc) {
		//return studentDao.findAllByPager(pageSize, pageNo, orderByProperty, desc);
	//}
	
	public void saveList(List<Student> sList) {
		studentDao.saveList(sList);
	}

	
	public IStudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(IStudentDao studentDao) {
		super.setBaseDao(studentDao);
		this.studentDao = studentDao;
	}
	
}

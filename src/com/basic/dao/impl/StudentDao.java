package com.basic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.basic.base.BaseDao;
import com.basic.dao.IStudentDao;
import com.basic.pojo.Student;
import com.basic.util.ChkUtil;
import com.basic.util.Page;

public class StudentDao extends BaseDao<Student, Integer> implements IStudentDao {

	//public void save(Student student) {		
		//super.save(student);
	//}
	
	//public void update(Student student) {
		//super.update(student);
	//}

	//public void delete(Student student) {
		//super.delete(student);
	//}

	//public Student findOne(int id) {
		//return super.findOne(id);
	//}
	
	//public List<Student> findAll(Student student) {
		//return super.findAll(student);
	//}
	
	//public Page<Student> findAllByPager(int pageSize, int pageNo) {
		//return super.findAllByPager(pageSize, pageNo);
	//}
	
	//public Page<Student> findAllByPager(int pageSize, int pageNo, String orderByProperty, boolean desc) {
		//return super.findAllByPager(pageSize, pageNo, orderByProperty, desc);
	//}
	
	public void saveList(List<Student> sList){
		if(sList.size() > 0){
			int sNum = sList.size();
			for(int i=0;i<sNum;i++){
				super.save(sList.get(i));
			}
		}
	}
	
}

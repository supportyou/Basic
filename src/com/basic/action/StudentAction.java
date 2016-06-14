package com.basic.action;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.basic.base.BaseAction;
import com.basic.service.IStudentService;
import com.basic.pojo.Student;
import com.basic.util.Page;

public class StudentAction extends BaseAction {

	private static final long serialVersionUID = -910456589191114077L;
	
	private IStudentService studentService;
	private List<Student> studentList;
	private Student student;
	private Integer id;
	
	private Page<Student> page;
	
	//protected int pageNo = 1;
	//protected int pageSize = 4;

	private String forWhere;

    public String save(){
    	if(this.validateForm()) {
            studentService.save(student);
            return "success";
    	} else {
            return "add";
    	}
    }
    
    public String update(){
    	if(this.validateForm()) {
    		studentService.update(student);
            return "findallbypager";
    	} else {
            return "amend";
    	}
    }
    
    public String delete(){
    	student=(Student) studentService.findOne(id);
    	studentService.delete(student);
    	return "findallbypager";
    }
    
    public String findOne(){
    	student=(Student) studentService.findOne(id);
    	//put2Request("student", student);
    	if (forWhere.equals("amend")) {
    		return "amend";
    	} else if (forWhere.equals("copy")) {
    		return "copy";
    	} else {
    		return "view";
    	}
    }
    
    public String findAll(){
    	studentList=studentService.findAll(student);
    	//put2Request("studentList", studentList);
    	return "findall";
    }
    
    public String findAllByPager(){
    	//page = studentService.findAllByPager(pageSize, pageNo);
    	page = studentService.findAllByPager(pageSize, pageNo, "id", true);
    	//put2Request("page", page);
    	return "findallbypager";
    }
    
    public void findAllForJson() throws Exception {
    	studentList=studentService.findAll(student);
    	
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(studentList);

		getResponse().setContentType("text/html;charset=UTF-8");
		getResponse().setHeader("cache-control", "no-cache");
		getResponse().setHeader("pragma", "no-cache");
		getResponse().setDateHeader("expires",0L);
		getResponse().getWriter().print(json);
		getResponse().getWriter().flush();
		getResponse().getWriter().close();
    }

    public String execute(){
    	return SUCCESS;
    }
    
	public boolean validateForm() {
		if(student!=null){
        	if (student.getUserName()==null || student.getUserName().equals("")) {
        		this.addFieldError("userName", "User Name can not be null!");
        		return false;
        	}
		} else {
			return false;
		}
		return true;
	}
    
	public IStudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Page<Student> getPage() {
		return page;
	}
	public void setPage(Page<Student> page) {
		this.page = page;
	}

	//public int getPageNo() {
		//return pageNo;
	//}

	//public void setPageNo(int pageNo) {
		//this.pageNo = pageNo;
	//}

	//public int getPageSize() {
		//return pageSize;
	//}

	//public void setPageSize(int pageSize) {
		//this.pageSize = pageSize;
	//}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getForWhere() {
		return forWhere;
	}
	public void setForWhere(String forWhere) {
		this.forWhere = forWhere;
	}
    
}

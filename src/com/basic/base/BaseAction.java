package com.basic.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	private static final long serialVersionUID = 1018499094241813786L;
	
	protected int pageNo = 1;
	protected int pageSize = 4;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	//General Method
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}

	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}
	
	// 往request作用域存放数据
	public void put2Request(String key, Object value) {
		getRequest().setAttribute(key, value);
	}

	//往Session作用域存放数据
	public void put2Session(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	//往ServletContext作用域存放数据
	public void put2Application(String key, Object value) {
		getServletContext().setAttribute(key, value);
	}
	
}

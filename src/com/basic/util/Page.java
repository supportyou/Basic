package com.basic.util;

import java.util.List;

/**
 * 分页数据模型类
 * @param <T> 要存放的实体类类型
 * @version 1.1
 */
public class Page<T> {

	/**当前页号*/
	private int pageNo;
	
	/**每页要返回的元素数*/
	private int pageSize;
	
	/** 总元素数 */
	private long totalElements;
	
	/**总页数: 根据总元素数和每页要显示的元素数计算得出 */
	private int totalPages;
	
	/**当前页的数据集合*/
	private List<T> content;
	
	public Page() {}
	
	public Page(int pageNo, int pageSize){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	
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
	
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
	
	public int getTotalPages() {
		totalPages = (int)((totalElements + pageSize - 1) / pageSize);
		return totalPages;
	}
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}

	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalElements="
				+ totalElements + ", totalPages=" + getTotalPages() + ", content="
				+ content + "]";
	}
}

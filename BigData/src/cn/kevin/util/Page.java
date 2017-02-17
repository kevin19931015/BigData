package cn.kevin.util;

import java.util.List;

import cn.kevin.domain.Customer;

public class Page {
	private List<Customer> records;
	private int pageSize=10;
	private int totalRecords;
	private int pageCount;
	private int startIndex;
	private int pageIndex;
	
	public Page(int pageIndex,int totalRecords){
		this.pageIndex = pageIndex;
		this.totalRecords = totalRecords;
		startIndex = (pageIndex-1)*10;
		pageCount = totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;
	}
	

	public int getPageSize() {
		return pageSize;
	}


	public List<Customer> getRecords() {
		return records;
	}

	public void setRecords(List<Customer> records) {
		this.records = records;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	

}

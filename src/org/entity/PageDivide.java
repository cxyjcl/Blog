package org.entity;

import java.util.List;

public class PageDivide {
	
	private int pageCode=1;
	//总的记录数
	private long totalRecored;
	//分页的页数
	private int totalPages;
	private List<Page> pageList;
	
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	public int getTotalPages() {
		int temp = (int) (totalRecored/10);
		return totalRecored%10>0?temp+1:temp;
	}
	public long getTotalRecored() {
		return totalRecored;
	}
	public void setTotalRecored(long total) {
		this.totalRecored = total;
	}
	public List getPageList() {
		return pageList;
	}
	public void setPageList(List pageList) {
		this.pageList = pageList;
	}
	@Override
	public String toString() {
		return "Page [pageCode=" + pageCode + ", totalPages=" + getTotalPages()
				+ ", totalRecored=" + totalRecored + ", pageList=" + pageList
				+ "]";
	}
	
}

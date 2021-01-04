package com.app.util;

import java.util.List;

/**
 * 分页工具类
 * 
 * @author Charles7c
 *
 * @param <T>
 */
public class PageBean<T> {

	private int pageSize; // 每页显示多少条
	private int currentPageNo; // 当前页
	private int totalPage; // 总页数
	private int totalCount; // 总记录数  
	private List<T> result; // 每页显示的内容集合  
	private int startIndex; // 起始索引

	// 获取起始索引时自动计算
	public int getStartIndex() {
		return (currentPageNo - 1) * pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		// 设置总记录数时 进行计算总页数
		if (totalCount > 0) {
			this.totalPage = (totalCount % pageSize) == 0 ? totalCount / pageSize : (totalCount / pageSize)+1;
		}
		this.totalCount = totalCount;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

}

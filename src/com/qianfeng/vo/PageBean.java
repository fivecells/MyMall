package com.qianfeng.vo;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	private int totalCount;
	private int currentPage;
	private int currentCount;
	private int totalPage;
	private List<T> productList = new ArrayList<>();
	public int getTotalCount() {
		return totalCount;
	}
	
	public PageBean(int totalCount, int currentPage, int currentCount, int totalPage, List<T> productList) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.currentCount = currentCount;
		this.totalPage = totalPage;
		this.productList = productList;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getProductList() {
		return productList;
	}
	public void setProductList(List<T> productList) {
		this.productList = productList;
	}
	public PageBean() {
		super();
		
	}
	
}

package com.qianfeng.domain;

import java.util.List;
import java.util.Map;

public class OrderItem {
	private String oid;
	private String pid;
	private String num;
	private List<Product> list;
	public OrderItem() {
		super();
		
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "OrderItem [oid=" + oid + ", pid=" + pid + ", num=" + num + ", list=" + list + "]";
	}
	
	
}

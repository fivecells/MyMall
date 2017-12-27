package com.qianfeng.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
	private String uid;
	private String oid;
	private String totalprice;
	private List<OrderItem> item;
	public Order() {
		super();
		
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public List<OrderItem> getItem() {
		return item;
	}
	public void setItem(List<OrderItem> item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "Order [uid=" + uid + ", oid=" + oid + ", totalprice=" + totalprice + ", item=" + item
				+ "]";
	}
	
}

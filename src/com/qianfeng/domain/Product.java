package com.qianfeng.domain;

import java.io.Serializable;
import java.util.Date;

/*  `pid` VARCHAR(32) NOT NULL,
  `pname` VARCHAR(50) DEFAULT NULL,
  `market_price` DOUBLE DEFAULT NULL,
  `shop_price` DOUBLE DEFAULT NULL,
  `pimage` VARCHAR(200) DEFAULT NULL,
  `pdate` DATE DEFAULT NULL,
  `is_hot` INT(11) DEFAULT NULL,
  `pdesc` VARCHAR(255) DEFAULT NULL,
  `pflag` INT(11) DEFAULT NULL,
  `cid` VARCHAR(32) DEFAULT NULL,
  PRIMARY KEY (`pid`)*/
public class Product implements Serializable{
	private String pid;
	private String pname;
	private String pimage;
	private String pdesc;
	private String cid;
	private double market_price;
	private double shop_price;
	private int is_hot;
	private int pflag;
	private Date pdate;
	public Product() {
		super();
		
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}
	public double getShop_price() {
		return shop_price;
	}
	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}
	public int getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}
	public int getPflag() {
		return pflag;
	}
	public void setPflag(int pflag) {
		this.pflag = pflag;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	
@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pimage=" + pimage + ", pdesc=" + pdesc
				+ ", cid=" + cid + ", market_price=" + market_price + ", shop_price="
				+ shop_price + ", is_hot=" + is_hot + ", pflag=" + pflag + ", pdate="
				+ pdate + "]";
	}
	//	@Override
//	public String toString() {
//		return "{\\\"pid\\\":\\\"" + pid + "\\\",\\\" pname\\\":\\\"" + pname + "\\\",\\\" pimage\\\":\\\"" + pimage + "\\\",\\\" pdesc\\\":\\\"" + pdesc
//				+ "\\\",\\\" cid\\\":\\\"" + cid + "\\\",\\\" market_price\\\":\\\"" + market_price + "\\\",\\\" shop_price\\\":\\\""
//				+ shop_price + "\\\",\\\" is_hot\\\":\\\"" + is_hot + "\\\",\\\" pflag\\\":\\\"" + pflag + "\\\",\\\" pdate\\\":\\\""
//				+ pdate + "\\\"}";
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + is_hot;
		long temp;
		temp = Double.doubleToLongBits(market_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pdate == null) ? 0 : pdate.hashCode());
		result = prime * result + ((pdesc == null) ? 0 : pdesc.hashCode());
		result = prime * result + pflag;
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((pimage == null) ? 0 : pimage.hashCode());
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		temp = Double.doubleToLongBits(shop_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (is_hot != other.is_hot)
			return false;
		if (Double.doubleToLongBits(market_price) != Double.doubleToLongBits(other.market_price))
			return false;
		if (pdate == null) {
			if (other.pdate != null)
				return false;
		} else if (!pdate.equals(other.pdate))
			return false;
		if (pdesc == null) {
			if (other.pdesc != null)
				return false;
		} else if (!pdesc.equals(other.pdesc))
			return false;
		if (pflag != other.pflag)
			return false;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		if (pimage == null) {
			if (other.pimage != null)
				return false;
		} else if (!pimage.equals(other.pimage))
			return false;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		if (Double.doubleToLongBits(shop_price) != Double.doubleToLongBits(other.shop_price))
			return false;
		return true;
	}
	
	
}

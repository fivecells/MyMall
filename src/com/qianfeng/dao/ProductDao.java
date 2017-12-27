package com.qianfeng.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qianfeng.domain.Category;
import com.qianfeng.domain.Order;
import com.qianfeng.domain.OrderItem;
import com.qianfeng.domain.Product;
import com.qianfeng.utils.C3P0Utils;
import com.qianfeng.vo.Condition;

public class ProductDao {

	QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	public int getTotalCount() throws SQLException {
		String sql = "select count(*) from product";
		Long totalCount = (Long) qr.query(sql, new ScalarHandler());
		return totalCount.intValue();
	}

	public List<Product> getProductList(int beginIndex, int currentCount) throws SQLException {
		String sql = "select * from product limit ?,?";
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class),beginIndex,currentCount);
		return productList;
	}

	public List<Category> getCategoryList() throws SQLException {
		String sql = "select * from category";
		List<Category> categoryList = qr.query(sql, new BeanListHandler<Category>(Category.class));
		
		return categoryList;
	}

	public List<Product> getProductListByCategory(int beginIndex, int currentCount, String cid) throws SQLException {
		String sql = "select * from product where cid=? limit ?,?";
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class),cid,beginIndex,currentCount);
		return productList;
	}

	public int getTotalCountByCategory(String cid) throws SQLException {
		String sql = "select count(*) from product where cid =?";
		Long totalCount = (Long) qr.query(sql, new ScalarHandler(),cid);
		return totalCount.intValue();
	}

	

	public Product getProductByPid(String pid) throws SQLException {
		String sql = "select * from product where pid =?";
		Product product = qr.query(sql, new BeanHandler<Product>(Product.class),pid);
		return product;
	}

	public List<Product> findProdutByWord(String word) throws SQLException {
		String sql = "select * from product where pname like ? limit 0,5";
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class),word+"%");
		
		return productList;
	}

	public void updateOrderItem(String oid, String pid, int productNum) throws SQLException {
		String sql = "insert into orderitem values(?,?,?)"; 
		qr.update(sql, oid,pid,productNum);
	}

	public void updateOrders(String oid, double totalPrice, int uid) throws SQLException {
		String sql = "insert into orders values(?,?,?)"; 
		qr.update(sql, oid,totalPrice,uid);
	}

	public int getOrdersCount() throws SQLException {
		String sql = "select count(*) from orders";
		Long  count = (Long) qr.query(sql, new ScalarHandler());
		return count.intValue();
	}

	public List<Product> getAllProductList() throws SQLException {
		String sql = "select * from product";
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return productList;
	}

	public Boolean deleteProduct(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "delete from product where pid = ?";
		System.out.println(pid);
		int isDelete = qr.update(sql, pid);
		if(isDelete!=0){
			return true;
		}
		return false;
	}

	public void addProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		int i = qr.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),
				product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid());
	}

	public void updateProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "update product set pname =?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
		int i = qr.update(sql,product.getPname(),product.getMarket_price(),product.getShop_price(),
				product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid(),product.getPid());
		System.out.println(i+product.getPid()+product.getPname()+product.getMarket_price()+product.getShop_price()+
				product.getPimage()+product.getPdate()+product.getIs_hot()+product.getPdesc()+product.getPflag()+product.getCid());
	}

	public List<Product> getProductList(Condition condition) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where 1=1 ";
		if(condition.getPname()!=null&&!condition.getPname().equals("")){
			sql+=" and pname like '%"+condition.getPname()+"%'";
		}
		if(condition.getIs_hot()!=null&&!condition.getIs_hot().equals("")){
			sql+=" and is_hot = "+condition.getIs_hot();
		}
		if(condition.getCid()!=null&&!condition.getCid().equals("")){
			sql+=" and cid ="+condition.getCid();
		}
		System.out.println(sql);
		List<Product> proList = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return proList;
	}

	public List<Order> getOrderListByUid(int uid) throws SQLException {
		String sql = "select * from orders where uid=?";
		List<Order> list = qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
		return list;
	}

	public List<OrderItem> getOrderItemListByOid(String oid) throws SQLException {
		String sql = "select * from orderitem where oid=?";
		List<OrderItem> list = qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),oid);
		return list;
	}

//	public void getOrdersListByUid(int uid) throws SQLException {
//		String sql = "SELECT * FROM orders o,orderitem oi,product p WHERE  uid=? AND o.oid=oi.oid AND oi.pid=p.pid";
//		List<Order> list = qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
//		System.out.println("dingdan");
//		System.out.println(list);
//	}

}

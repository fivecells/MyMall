package com.qianfeng.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.qianfeng.dao.ProductDao;
import com.qianfeng.domain.Category;
import com.qianfeng.domain.Order;
import com.qianfeng.domain.OrderItem;
import com.qianfeng.domain.Product;
import com.qianfeng.domain.User;
import com.qianfeng.vo.Condition;
import com.qianfeng.vo.PageBean;

public class ProductService {
	
	ProductDao dao = new ProductDao();

	public PageBean<Product> getPageBean(int currentPage, int currentCount) {
		int totalCount = 0;
//		获得产品总数
		try {
			totalCount = dao.getTotalCount();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
//		计算总页数
		int totalPage = (int) Math.ceil(totalCount*1.0/currentCount);
		//计算当前页的起始索引
		int beginIndex = (currentPage-1)*currentCount;
		//获得所当前页的产品
		List<Product> productList = null;
		try {
			productList = dao.getProductList(beginIndex,currentCount);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
//		封装pageBean
		PageBean<Product> pageBean = new PageBean<>(totalCount, currentPage, currentCount, totalPage, productList);
				
		return pageBean;
	}

	public List<Category> getCategoryList() {
		List<Category> categoryList = null;
		try {
			categoryList = dao.getCategoryList();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return categoryList;
	}

	public PageBean getPageBeanByCategory(int currentPage, int currentCount, String cid) {
		int totalCount = 0;
//		获得此种类产品总数
		try {
			totalCount = dao.getTotalCountByCategory(cid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
//		计算总页数
		int totalPage = (int) Math.ceil(totalCount*1.0/currentCount);
		//计算当前页的起始索引
		int beginIndex = (currentPage-1)*currentCount;
		//获得当前所有种类的产品
		List<Product> productList = null;
		try {
			productList = dao.getProductListByCategory(beginIndex,currentCount,cid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
//		封装pageBean
		PageBean<Product> pageBean = new PageBean<>(totalCount, currentPage, currentCount, totalPage, productList);
				
		return pageBean;
	}

	

	public Product getProductByPid(String pid)  {
		Product product=null;
		try {
			product = dao.getProductByPid(pid);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return product;
	}

	public List<Product> findProductByWord(String word) {
		List<Product> productList=null;
		try {
			productList = dao.findProdutByWord(word);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return productList;
	}

	public List<Product> getShoppingCart(Enumeration<String> attNames) {
		int pid=0;
		List<Product> list = new ArrayList<>();
		while(attNames.hasMoreElements()){
			String str = attNames.nextElement();
			
			try {
				pid = Integer.parseInt(str);
				Product product = dao.getProductByPid(String.valueOf(pid));
				
				list.add(product);
			} catch (NumberFormatException e) {
			} catch (SQLException e) {
			}
			
		}
		
		return list;
	}

	public void updateOrderItem(String oid, String pid, int productNum) {
		try {
			dao.updateOrderItem(oid, pid, productNum);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void updateOrders(String oid, double totalPrice, int uid) {
		try {
			dao.updateOrders(oid, totalPrice, uid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public int getOrdersCount() {
		int count = 0;
		try {
			count = dao.getOrdersCount();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return count;
	}

	public List<Product> getAllProductList() {
		List<Product> productList =null;
		try {
			productList = dao.getAllProductList();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return productList;
	}

	public Boolean deleteProduct(String pid) {
		Boolean isDelete = false;
		try {
			isDelete = dao.deleteProduct(pid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return isDelete;
	}

	public void addProduct(Product product) throws SQLException {
		dao.addProduct(product);
	}

	public void updateProduct(Product product) throws SQLException {
		dao.updateProduct(product);
	}

	public List<Product> getProductList(Condition condition) throws SQLException {
		List<Product> proList = dao.getProductList(condition);
		return proList;
	}

//	public void getOrdersListByUid(int uid) {
//		dao.getOrderByUid(uid);
//	}

	public Map<Order, Map<Product, String>> getOrderMapByUid(int uid) {

		Map<Order, Map<Product, String>> orderMap= new TreeMap<>(new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				int result = o1.getOid().compareTo(o2.getOid());
				return -result;
			}
			
		});
		try {
			List<Order>list =  dao.getOrderListByUid(uid);
			System.out.println("list"+list);
			for (Order order : list) {
				Map<Product, String> map= new HashMap<>();
				String oid = order.getOid();
				
				List<OrderItem> list2 = dao.getOrderItemListByOid(oid);
				System.out.println("list2:"+list2);
				for (OrderItem orderItem : list2) {
					String pid = orderItem.getPid();
					String num = orderItem.getNum();
					System.out.println("pid"+pid);
					Product product = dao.getProductByPid(pid);
					map.put(product, num);
				}
				orderMap.put(order, map);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("servicemap:"+orderMap);
		return orderMap;
	}
}

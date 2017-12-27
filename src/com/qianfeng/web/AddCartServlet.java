package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.qianfeng.domain.Product;
import com.qianfeng.domain.User;
import com.qianfeng.service.ProductService;

public class AddCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//通过ajax获得对象产品的修改过得toString字段，再通过Gson反序列化获得对象，但是出现部分字段为null.
		/*String product = request.getParameter("product");
		String  num = request.getParameter("num");
		Gson gson = new Gson();
		ProductService service = new ProductService();
		Product product2 =null;
		try {
			product2 = service.getProductByPid("1");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		String json = gson.toJson(product2);
		System.out.println(json);
		System.out.println(product);
		Product product3 = gson.fromJson(product, Product.class);
		System.out.println(product3);*/
		String pid = request.getParameter("pid");
		String num = request.getParameter("num");
		int pronum = Integer.parseInt(num);
		ProductService service = new ProductService();
		Product product = service.getProductByPid(pid);
		HttpSession session = request.getSession();
		Map<Product, Integer> cartMap=null;
		if (session.getAttribute("cartMap")==null) {
			cartMap = new HashMap<>();
			cartMap.put(product, pronum);
			session.setAttribute("cartMap",cartMap);
		}else{
			cartMap = (Map<Product, Integer>) session.getAttribute("cartMap");
			System.out.println("session:"+cartMap);
			if(cartMap.containsKey(product)){
				Integer num_old = cartMap.get(product);
				cartMap.put(product,num_old+pronum);
				session.setAttribute("cartMap",cartMap);
			}else{
				cartMap.put(product, pronum);
				session.setAttribute("cartMap",cartMap);
			}
		}
		System.out.println(cartMap);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
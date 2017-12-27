package com.qianfeng.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qianfeng.domain.Product;
import com.qianfeng.service.ProductService;

public class AdminForAddProduct extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();
		Product product = new Product();
		try {
			BeanUtils.populate(product, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
//		product.setPid(UUID.randomUUID().toString());
		product.setPimage("products/1/c_0003.jpg");
		product.setPflag(1);
		product.setPdate(new Date());
		ProductService service = new ProductService();
		try {
			service.addProduct(product);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("here");
		response.sendRedirect(request.getContextPath()+"/adminProductList");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
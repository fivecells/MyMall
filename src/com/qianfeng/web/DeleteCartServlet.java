package com.qianfeng.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.Product;
import com.qianfeng.service.ProductService;

public class DeleteCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<Product, Integer> cartMap = (Map<Product, Integer>) session.getAttribute("cartMap");
		String[] orderPids = request.getParameterValues("orderPids");
		ProductService service = new ProductService();
		for (String pid : orderPids) {
			Product product = service.getProductByPid(pid);
			cartMap.remove(product);
		}
		session.setAttribute("cartMap", cartMap);
		response.sendRedirect(request.getContextPath()+"/shoppingCart.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

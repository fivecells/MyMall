package com.qianfeng.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.Order;
import com.qianfeng.domain.Product;
import com.qianfeng.domain.User;
import com.qianfeng.service.ProductService;

public class ShowOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		ProductService service = new ProductService();
		Map<Order,Map<Product,String>> historyOrdersMap = service.getOrderMapByUid(user.getUid());
		System.out.println("servlet:"+historyOrdersMap);
		session.setAttribute("historyOrdersMap", historyOrdersMap);
		response.sendRedirect(request.getContextPath()+"/orders.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
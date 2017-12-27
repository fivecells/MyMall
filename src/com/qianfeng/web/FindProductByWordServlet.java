package com.qianfeng.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qianfeng.domain.Product;
import com.qianfeng.service.ProductService;

public class FindProductByWordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String word = request.getParameter("word");
		System.out.println(word);
		ProductService service = new ProductService();
		List<Product> productList = service.findProductByWord(word);
		Gson gson = new Gson();
		String json = gson.toJson(productList);
		response.getWriter().write(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
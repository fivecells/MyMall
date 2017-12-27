package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Category;
import com.qianfeng.domain.Product;
import com.qianfeng.service.AdminCategoryListService;
import com.qianfeng.service.ProductService;
import com.qianfeng.vo.Condition;

public class AdminResearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pname = request.getParameter("pname");
		String is_hot = request.getParameter("is_hot");
		String cid = request.getParameter("cid");
		Condition condition  = new Condition();
		condition.setPname(pname);
		condition.setIs_hot(is_hot);
		condition.setCid(cid);
		System.out.println(pname+is_hot+cid);
		ProductService service = new ProductService();
		List<Product> productList=null;
		try {
			productList = service.getProductList(condition);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("condition", condition);
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("/admin/list.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

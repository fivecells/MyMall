package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Category;
import com.qianfeng.service.AdminCategoryListService;

public class AdminEditCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cid = request.getParameter("cid");
		AdminCategoryListService service =  new AdminCategoryListService();
		Category category =null;
		try {
			category = service.getCategory(cid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("category", category);
		request.getRequestDispatcher("admin/editCategory.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
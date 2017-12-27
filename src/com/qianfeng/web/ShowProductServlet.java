package com.qianfeng.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Category;
import com.qianfeng.domain.Product;
import com.qianfeng.service.ProductService;
import com.qianfeng.vo.PageBean;

public class ShowProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductService service = new ProductService();
		int currentCount=10;
		String currentPagestr = request.getParameter("currentPage");
		if(currentPagestr==null){
			currentPagestr="1";
		}
		int currentPage=Integer.parseInt(currentPagestr);
		PageBean<Product> pageBean = service.getPageBean(currentPage, currentCount);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("/showProduct.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

package com.qianfeng.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Category;
import com.qianfeng.service.ProductService;
import com.qianfeng.vo.PageBean;

public class GetProductByCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentCount=10;
		String currentPagestr = request.getParameter("currentPage");
		if(currentPagestr==null){
			currentPagestr="1";
		}
		int currentPage=Integer.parseInt(currentPagestr);
		String cid = request.getParameter("cid");
		ProductService service = new ProductService();
		PageBean pageBean = service.getPageBeanByCategory(currentPage,currentCount,cid);
		List<Category> categoryList = service.getCategoryList();
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("cid", cid);
		request.getRequestDispatcher("/showProduct.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
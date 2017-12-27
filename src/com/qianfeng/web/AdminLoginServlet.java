package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.User;
import com.qianfeng.service.UserService;

public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		System.out.println("admin:"+username+pwd);
		UserService service = new UserService();
		Admin admin = service.checkAdmin(username,pwd);
//			System.out.println(user);
		if(admin!=null){
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect(request.getContextPath()+"/admin/admin_index.jsp");
		}else{
			request.setAttribute("info", "用户名或密码错误");
			request.getRequestDispatcher("/admin/admin_login.jsp").forward(request, response);
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
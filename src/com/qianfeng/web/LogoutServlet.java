package com.qianfeng.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
//		Cookie[] cookies = request.getCookies();
//		for (Cookie cookie : cookies) {
//			cookie.setMaxAge(0);
//			cookie.setPath("/");
//			response.addCookie(cookie);
//		}
		Cookie Cookie1=new Cookie("username",null); //假如要删除名称为username的Cookie
		Cookie Cookie2=new Cookie("password",null); //假如要删除名称为username的Cookie

		Cookie1.setMaxAge(0); //立即删除型

		Cookie2.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除

		response.addCookie(Cookie1); //重新写入，将覆盖之前的
		response.addCookie(Cookie2); //重新写入，将覆盖之前的
		response.sendRedirect(request.getContextPath()+"/showProductServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

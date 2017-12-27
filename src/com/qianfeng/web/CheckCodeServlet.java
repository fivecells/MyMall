package com.qianfeng.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String checkCode = request.getParameter("checkCode");
		System.out.println("check:"+checkCode);
		HttpSession session = request.getSession();
		String  word = (String) session.getAttribute("checkcode_session");
		if(word.equals(checkCode)){
			response.getWriter().write("true");
		}else{
			response.getWriter().write("false");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
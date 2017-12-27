package com.qianfeng.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.qianfeng.domain.User;
import com.qianfeng.service.UserService;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		String check = request.getParameter("check");
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		String  word = (String) session.getAttribute("checkcode_session");
		System.out.println("check:"+check);
		System.out.println("name:"+name);
		if(word.equals(check)){
			Map<String, String[]> map = request.getParameterMap();
			System.out.println("map"+map);
			User user= new User();
			try {
				BeanUtils.populate(user,map);
			} catch (IllegalAccessException | InvocationTargetException e) {
				
				e.printStackTrace();
			}
			System.out.println(user);
			UserService service = new UserService();
			int rows = service.addUser(user);
			request.getRequestDispatcher("/registerSuccessful.jsp").forward(request, response);
		}else{
			request.setAttribute("info", "验证码错误");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
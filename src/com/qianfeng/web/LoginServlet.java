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

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		String check = request.getParameter("check");
		HttpSession session = request.getSession();
		String  word = (String) session.getAttribute("checkcode_session");
		String autoLogin = request.getParameter("autoLogin");
		UserService service = new UserService();
		User user=null;
			try {
				user = service.checkUser(username,pwd);
				//			System.out.println(user);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		if(!word.equals(check)){
			request.setAttribute("info", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(user!=null){
			if("1".equals(autoLogin)){//一次空指针异常
				//username和password分开存
				Cookie cookie = new Cookie("username",user.getUsername());
				Cookie cookie2 = new Cookie("password",user.getPassword());
				System.out.println("自动登录缓存"+user.getUsername()+user.getPassword());
				cookie.setMaxAge(60*60*24*3);
				cookie2.setMaxAge(60*60*24*3);
//				setpath设置必要吗？
//				cookie.setPath(request.getContextPath());
//				cookie2.setPath(request.getContextPath());
				response.addCookie(cookie);
				response.addCookie(cookie2);
			}
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/showProductServlet");
		}else{
			request.setAttribute("info", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
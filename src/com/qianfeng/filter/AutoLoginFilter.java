package com.qianfeng.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.Category;
import com.qianfeng.domain.User;
import com.qianfeng.service.ProductService;
import com.qianfeng.service.UserService;

public class AutoLoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ProductService proService = new ProductService();
		List<Category> categoryList = proService.getCategoryList();
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		session.setAttribute("categoryList", categoryList);
		Cookie[] cookies = httpRequest.getCookies();
		String username=null;
		String password=null;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if ("username".equals(cookie.getName())){
					username=cookie.getValue();
					System.out.println("username:"+username);
				}
				if ("password".equals(cookie.getName())){
					password=cookie.getValue();
				}
				
			}
			User user =null;
			//空指针异常
			if(username!=null&&password!=null){
				UserService service = new UserService();
				try {
					user = service.checkUser(username, password);
					System.out.println("过滤器得到user:"+user);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				if(user!=null){
					session.setAttribute("user", user);
				}	
			}
			
		}
		chain.doFilter(httpRequest, response);
	}

	@Override
	public void destroy() {
	}

}

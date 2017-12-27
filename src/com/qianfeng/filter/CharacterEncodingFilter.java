package com.qianfeng.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CharacterEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		EnhanceRequest  enhanceRequest = new EnhanceRequest((HttpServletRequest)request); 
		chain.doFilter(enhanceRequest, response);
		System.out.println("编码已经设置为utf-8");
	}

	@Override
	public void destroy() {
	}

}

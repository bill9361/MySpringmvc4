package com.bill.springmvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义过滤器能够解决当前工程下的所有中文乱码问题
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月10日上午11:44:55<br/>
 * 类说明：
 */
public class EncodingFilter implements Filter
{

	/**
	 * 用于Filter销毁前，完成某些资源回收
	 */
	@Override
	public void destroy()
	{}

	/**
	 * 实现过滤功能
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		System.out.println("EncodingFilter....doFilter()");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		chain.doFilter(request, response);
	}

	/**
	 * 用于完成Filter初始化
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException
	{}
	
	

}

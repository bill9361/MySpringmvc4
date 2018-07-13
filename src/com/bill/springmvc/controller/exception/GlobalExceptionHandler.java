package com.bill.springmvc.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 能够处理当前项目中<context:component-scan base-package="com.bill.springmvc.controller">下所有Controller的异常@ControllerAdvice
 * 而且当前@ControllerAdvice注解的类必须包含在component-scan的范围内
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月10日下午3:18:44<br/>
 * 类说明：统一异常处理（dao--->service--->controller(都是抛异常)）
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandle(Exception ex)
	{
		System.out.println("GlobalExceptionHandler...哈哈，恭喜您出错啦");
		ex.printStackTrace();
		return "error.jsp";
	}
}


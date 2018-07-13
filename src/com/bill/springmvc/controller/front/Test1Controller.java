package com.bill.springmvc.controller.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bill.springmvc.model.entity.User;

/**
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月9日下午3:26:32<br/>
 * 类说明：
 */
@RequestMapping("/front")
@Controller
public class Test1Controller
{

	@RequestMapping("/test1")
	public String test1()
	{
		System.out.println("Test1Controller....test1");

		return "success.jsp";
	}

	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public String test2(User user)
	{
		System.out.println("Test1Controller....test2");
		System.out.println(user);

		return "/page/success.jsp";
	}

	/**
	 * 测试@RequestParam注解
	 * 
	 * @param username
	 * @param password
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public String test3(@RequestParam(name = "uname") String username, @RequestParam(name = "upwd") String password,
			@RequestParam(name = "age", required = true) String age)
	{
		System.out.println("Test1Controller....test3");
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		System.out.println("age:" + age);

		return "/page/success.jsp";
	}

	/**
	 * 传统方式的转发与重定向
	 * 
	 * @param uname
	 * @param upwd
	 * @param age
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/test4", method = RequestMethod.POST)
	public void test4(String uname, String upwd, String age, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		System.out.println("Test1Controller....test4");
		System.out.println("uname:" + uname);
		System.out.println("upwd:" + upwd);
		if ("admin".equals(uname) && "123".equals(upwd))
		{
			// 传统的转发方式(默认会加上项目名)
			// request.getRequestDispatcher("/page/success.jsp").forward(request,
			// response);
			// 传统的重定向方式(需要加上项目名)
			response.sendRedirect("/MySpringmvc4/page/success.jsp");
		} else
		{
			// 传统的转发方式
			request.getRequestDispatcher("/page/fail.jsp").forward(request, response);
		}
		// return "/page/success.jsp";
	}

	/**
	 * SpringMVC转发与重定向
	 * 
	 * @param uname
	 * @param upwd
	 * @param age
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/test5", method = RequestMethod.POST)
	public String test5(String uname, String upwd, String age, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		System.out.println("Test1Controller....test5");
		System.out.println("uname:" + uname);
		System.out.println("upwd:" + upwd);
		if ("admin".equals(uname) && "123".equals(upwd))
		{
			// 传统的转发方式(默认会加上项目名)
			// request.getRequestDispatcher("/page/success.jsp").forward(request,
			// response);
			// 传统的重定向方式(需要加上项目名)
			// response.sendRedirect("/MySpringmvc4/page/success.jsp");
			// SpringMVC的方式（test5）,会默认加上项目名
			return "redirect:/page/success.jsp";
		} else
		{
			// 传统的转发方式
			// request.getRequestDispatcher("/page/fail.jsp").forward(request,
			// response);
			// 默认就是转发
			return "/page/fail.jsp";
		}
		// return "/page/success.jsp";
	}

	/**
	 * 视图解析器
	 * 
	 * @param uname
	 * @param upwd
	 * @param age
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/test6", method = RequestMethod.POST)
	public String test6(String uname, String upwd, String age, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		System.out.println("Test1Controller....test6");
		System.out.println("uname:" + uname);
		System.out.println("upwd:" + upwd);
		if ("admin".equals(uname) && "123".equals(upwd))
		{
			// 视图解析器对重定向无效，只对转发有效
			return "redirect:/page/success.jsp";
		} else
		{
			// 视图解析器前缀+return值+视图解析器后缀
			return "fail.jsp";
		}
	}

	/**
	 * 解决中文乱码问题
	 * 
	 * @param uname
	 * @param upwd
	 * @param age
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/test7", method = RequestMethod.POST)
	public String test7(String uname, String upwd, String age, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		System.out.println("Test1Controller....test7");
		System.out.println("uname:" + uname);
		System.out.println("upwd:" + upwd);
		if ("admin".equals(uname) && "123".equals(upwd))
		{
			// 视图解析器对重定向无效，只对转发有效
			return "redirect:/page/success.jsp";
		} else
		{
			// 视图解析器前缀+return值+视图解析器后缀
			return "fail.jsp";
		}
	}

	/**
	 * 通过request、session、application域存放数据
	 * 
	 * @param uname
	 * @param upwd
	 * @param age
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/test8", method = RequestMethod.POST)
	public String test8(String uname, String upwd, String age, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception
	{
		System.out.println("Test1Controller....test8");
		System.out.println("uname:" + uname);
		System.out.println("upwd:" + upwd);
		// request.setAttribute("username", uname);
		// request.getServletContext()对应applicationScope对象，被所有用户共享，只要服务器没关闭，都存活
		// request.getServletContext().setAttribute("username", uname);
		session.setAttribute("username", uname);
		if ("admin".equals(uname) && "123".equals(upwd))
		{
			// 以前的request中存放的变量全部失效，并进入一个新的request作用域。
			// 视图解析器对重定向无效，只对转发有效
			return "redirect:/page/success.jsp";
		} else
		{
			// 视图解析器前缀+return值+视图解析器后缀
			return "fail.jsp";
		}
	}

	/**
	 * Model/Map<String,Object>默认存放到request域中
	 * 
	 * @param uname
	 * @param upwd
	 * @param age
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/test9", method = RequestMethod.POST)
	public String test9(String uname, String upwd, String age, Model model, Map<String, Object> map) throws Exception
	{
		System.out.println("Test1Controller....test9");
		System.out.println("uname:" + uname);
		System.out.println("upwd:" + upwd);
		// model.addAttribute("username1", uname);
		map.put("username2", uname);
		if ("admin".equals(uname) && "123".equals(upwd))
		{
			return "success.jsp";
		} else
		{
			return "fail.jsp";
		}
	}

	/**
	 * 统一异常处理
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/test10")
	public void test10() throws Exception
	{
		System.out.println("Test1Controller....test10");
		int i = 10 / 0;
	}
	
	/**
	 * SpringMVC异常处理@ExceptionHandler，当前类的@ExceptionHandler方法只接收当前类的异常
	 */
	/*@ExceptionHandler(Exception.class)
	public String exceptionHandle(Exception ex)
	{
		System.out.println("哈哈，恭喜您出错啦");
		ex.printStackTrace();
		return "error.jsp";
	}
	*/

	/**
	 * SpringMVC异常处理@ExceptionHandler，当前类的@ExceptionHandler方法只接收当前类的异常
	 * 如果发生异常是：ArithmeticException，会执行此方法
	 */
	/*@ExceptionHandler(ArithmeticException.class)
	public String exceptionHandle2(Exception ex)
	{
		System.out.println("哈哈，恭喜您出错啦2");
		ex.printStackTrace();
		return "error.jsp";
	}*/
	
	/**
	 * 该注解需要开启注解驱动@ResponseBody，使用了@ResponseBody注解时，访问时候的后缀不能使用.html或.htm结尾
	 * 返回字符串数据
	 * @return
	 */
	@RequestMapping("/test11")
	@ResponseBody
	public String test11() throws Exception
	{
		System.out.println("Test1Controller....test11()");
		return "Hello";
	}
	
	/**
	 * 通过@ResponseBody返回实体，会SpringMVC会自动以Json格式返回
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/test12")
	@ResponseBody
	public User test12(@CookieValue("JSESSIONID") String jsessionid) throws Exception
	{
		System.out.println("Test1Controller....test12()");
		System.out.println(jsessionid);
		User user = new User();
		user.setUsername("李哈哈");
		user.setPassword("123456");
		user.setAge(30);
		return user;
	}
	/**
	 * 通过@ResponseBody返回Map<String, Object>，会SpringMVC会自动以Json格式返回
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/test13")
	@ResponseBody
	public Map<String, Object> test13() throws Exception
	{
		System.out.println("Test1Controller....test13()");
		Map<String, Object> map = new HashMap<>();
		map.put("username", "zhangsan");
		map.put("password", "123458");
		return map;
	}
	
	/**
	 * 通过@ResponseBody返回List<Map<String, Object>>，会SpringMVC会自动以Json格式返回
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/test14")
	@ResponseBody
	public List<Map<String, Object>> test14() throws Exception
	{
		System.out.println("Test1Controller....test14()");
		List<Map<String, Object>> listMap = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("username", "zhangsan");
		map1.put("password", "123458");
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("username", "aaa");
		map2.put("password", "666");
		
		listMap.add(map1);
		listMap.add(map2);
		return listMap;
	}
}





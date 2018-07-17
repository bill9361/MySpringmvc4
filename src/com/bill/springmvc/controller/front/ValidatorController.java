package com.bill.springmvc.controller.front;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bill.springmvc.model.entity.User;
import com.bill.springmvc.util.Validator;

/**
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月17日上午11:50:32<br/>
 * 类说明：数据校验控制器
 */
@RequestMapping("/validator")
@Controller
public class ValidatorController
{
	/**
	 * 数据校验1
	 * 传统方式
	 * @return
	 */
	@RequestMapping("/register1")
	public String register1(User user)
	{
		System.out.println("ValidatorController....register1()");
		System.out.println(user);
		
		boolean flagNick = user.getNick().matches("[\u4e00-\u9fa5]{4,10}");
		boolean flagPw = user.getPassword().matches("[A-Za-z0-9_]{3,16}");
		boolean flagPhone = user.getPhone().matches("1[35789]\\d{9}");
		boolean flagUsername = user.getUsername().matches("[A-Za-z0-9_]{3,16}");
		boolean flagEmail = user.getEmail().matches("\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+");
		boolean flagAge = user.getAge().toString().matches("\\d{1,3}");
		
		System.out.println("flagNick:"+flagNick);
		System.out.println("flagPw:"+flagPw);
		System.out.println("flagPhone:"+flagPhone);
		System.out.println("flagUsername:"+flagUsername);
		System.out.println("flagEmail:"+flagEmail);
		System.out.println("flagAge:"+flagAge);
		
		if(flagNick && flagPw && flagPhone && flagUsername && flagEmail && flagAge)
		{
			System.out.println("数据正确");
		}
		else
		{
			System.out.println("您输入有误");
		}
		
		return "/register_success.jsp";
		
	}
	
	/**
	 * 数据校验2
	 * 注意：BindingResult必须紧跟在@Valid修饰的形参后面，否则框架通过反射接收不到
	 * SpringMVC方式@Valid
	 * @return
	 */
	@RequestMapping("/register2")
	public String register2(@Valid User user, BindingResult errorResult, Model model)
	{
		System.out.println("ValidatorController....register2()");
		System.out.println(user);
		
		Map<String, String> errorMap = Validator.fieldValidate(errorResult);
		if(errorMap != null)
		{
			//校验不通过
			model.addAttribute("errorMap", errorMap);
			
			return "/register.jsp";
		}
		
		return "/register_success.jsp";
	}

}

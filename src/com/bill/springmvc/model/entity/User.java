package com.bill.springmvc.model.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月17日上午11:32:04<br/>
 * 类说明：用户实体类
 */
public class User
{
	@NotNull(message = "用户名不能为Null")
	@NotEmpty(message = "用户名不能为空")
	@Pattern(regexp = "\\w{3,16}", message = "用户名必须为3-16位数字、字母、下划线组合")
	private String username;//用户名(长度为3-16位数字、字母、_组合)
	
	@NotNull(message = "昵称不能为Null")
	@NotEmpty(message = "昵称不能为空")
	@Pattern(regexp = "[\u4e00-\u9fa5]{4,10}", message = "昵称必须为4-10位汉字")
	private String nick;	//昵称(长度为4-10个汉字)
	
	@NotNull(message = "密码不能为Null")
	@NotEmpty(message = "密码不能为空")
	@Pattern(regexp = "\\w{3,16}", message = "密码必须为3-16位数字、字母、下划线组合")
	private String password;//密码(长度为3-16位数字、字母、_组合)
	
	@Pattern(regexp = "1[35789]\\d{9}", message = "手机号格式不正确")
	private String phone;	//手机(长度为11位，以13|5|7|8|9开头)
	
	@Email(message = "邮箱格式不正确")
	private String email;	//邮箱
	
	@Min(value = 1, message = "年龄必须大于等于1")
	@Max(value = 150, message = "年龄必须小于等于150")
	private Integer age;	//年龄(必须为数字，必须在1-150岁之间)
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getNick()
	{
		return nick;
	}
	public void setNick(String nick)
	{
		this.nick = nick;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public Integer getAge()
	{
		return age;
	}
	public void setAge(Integer age)
	{
		this.age = age;
	}
	@Override
	public String toString()
	{
		return "User [username=" + username + ", nick=" + nick + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", age=" + age + "]";
	}
	
}

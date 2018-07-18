package com.bill.springmvc.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 作者Email:fengminbiao@126.com<br/>
 * 创建时间：2018年7月18日上午10:59:37<br/>
 * 类说明：定时器1(启动服务器之后，需要访问一次controller才能生效)
 */
@Component("testTask1")
public class TestTask1
{
	/**
	 * 每秒钟执行一次
	 */
	/*@Scheduled(fixedRate = 1000)
	public void task1()
	{
		System.out.println(new Date());
	}*/

	
	/**
	 * 年份（1970－2099）——@Scheduled是不支持的，spring quartz支持
	 * spring taks 不支持年位定时,它毕竟不是quartz,只是简单的定时框架
	 * Cron表达式最大只能指定6个字段
	 * 按照一定的时间规律执行该方法
	 * 秒 分 时  天 月 周 年
	 */
	@Scheduled(cron = "0 15 10 * * *")
	public void task2()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(dateFormat.format(new Date()));
	}
}

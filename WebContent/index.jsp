<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>new jsp</title>
</head>
	<body>
		<a href="front/test1.do">Test1</a>
		<hr/>
		<form action="front/test9.do" method="post">
			<p>用户名：<input type="text" name="uname"/></p>
			<p>密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text" name="upwd"/></p>
			<p><input type="submit" value="提交"/></p>
		</form>
		<hr/>
		<a href="front/test10.do">统一异常处理</a>
		<hr/>
		<a href="front/test11.do">测试返回字符串数据</a>
		<hr/>
		<a href="front/test12.do">测试返回实体</a>
		<hr/>
		<a href="front/test13.do">测试返回Map</a>
		<hr/>
		<a href="front/test14.do">测试返回List&lt;Map&lt;String,Object&gt;&gt;</a>
		<hr/>
		<a href="page/upload_file.jsp">文件上传</a>
		<hr/>
		<a href="page/register.jsp">注册(数据校验)</a>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户注册</title>
</head>
<body>
	<center>
		<!-- <form action="validator/register1.do" method="post">
			<table>
				<tr>
					<td>用户名</td>
					<td><input style="width: 300px;" type="text" name="username" pattern="[A-Za-z0-9_]{3,16}" required="required" placeholder="请输入3-16位数字、字母、下划线组合"></td>
				</tr>
				<tr>
					<td>昵称</td>
					<td><input style="width: 300px;" type="text" name="nick" pattern="[\u4e00-\u9fa5]{4,10}" required="required" placeholder="请输入4-10位汉字"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input style="width: 300px;" type="password" name="password" pattern="[A-Za-z0-9_]{3,16}" required="required" placeholder="请输入3-16位数字、字母、下划线组合"></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input style="width: 300px;" type="text" name="phone" pattern="1[35789]\d{9}" required="required" placeholder="请输入正确的手机格式"></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input style="width: 300px;" type="text" name="email" pattern="\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+" required="required" placeholder="请输入正确的邮箱格式"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input style="width: 300px;" type="text" name="age" pattern="\d{1,3}" placeholder="请输入数字"></td>
				</tr>
				<tr>
					<td colspan="2" style="width: 300px;" align="center">
					<input style="width: 100px;" type="submit" value="注册">
					<input style="width: 100px;" type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form> -->
		
		<!-- <form action="validator/register1.do" method="post">
			<table>
				<tr>
					<td>用户名</td>
					<td><input style="width: 300px;" type="text" name="username" placeholder="请输入3-16位数字、字母、下划线组合"></td>
				</tr>
				<tr>
					<td>昵称</td>
					<td><input style="width: 300px;" type="text" name="nick" placeholder="请输入4-10位汉字"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input style="width: 300px;" type="password" name="password" placeholder="请输入3-16位数字、字母、下划线组合"></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input style="width: 300px;" type="text" name="phone" placeholder="请输入正确的手机格式"></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input style="width: 300px;" type="text" name="email" placeholder="请输入正确的邮箱格式"></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input style="width: 300px;" type="text" name="age" placeholder="请输入数字"></td>
				</tr>
				<tr>
					<td colspan="2" style="width: 300px;" align="center">
					<input style="width: 100px;" type="submit" value="注册">
					<input style="width: 100px;" type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form> -->
		
		<form action="validator/register2.do" method="post">
			<table>
				<tr>
					<td>用户名</td>
					<td><input style="width: 300px;" type="text" name="username" value="${requestScope.errorMap.username==null?requestScope.user.username:"" }" placeholder="请输入3-16位数字、字母、下划线组合"><span style="color: red;">${requestScope.errorMap.username }</span></td>
				</tr>
				<tr>
					<td>昵称</td>
					<td><input style="width: 300px;" type="text" name="nick" placeholder="请输入4-10位汉字"><span style="color: red;">${requestScope.errorMap.nick }</span></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input style="width: 300px;" type="password" name="password" placeholder="请输入3-16位数字、字母、下划线组合"><span style="color: red;">${requestScope.errorMap.password }</span></td>
				</tr>
				<tr>
					<td>手机号码</td>
					<td><input style="width: 300px;" type="text" name="phone" placeholder="请输入正确的手机格式"><span style="color: red;">${requestScope.errorMap.phone }</span></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input style="width: 300px;" type="text" name="email" placeholder="请输入正确的邮箱格式"><span style="color: red;">${requestScope.errorMap.email }</span></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input style="width: 300px;" type="text" name="age" placeholder="请输入数字"><span style="color: red;">${requestScope.errorMap.age }</span></td>
				</tr>
				<tr>
					<!-- <td colspan="2" style="width: 300px;" align="center"> -->
					<td colspan="2" style="width: 300px;">
					<input style="width: 100px;" type="submit" value="注册">
					<input style="width: 100px;" type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
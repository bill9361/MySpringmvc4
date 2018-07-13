<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>文件上传</title>
</head>
<body>
	<form action="upload/singleFileUpload.do" enctype="multipart/form-data">
		<p>头像：<input type="file" name="headName"/></p>
		<p><input type="submit" value="上传"/></p>
	</form>
</body>
</html>
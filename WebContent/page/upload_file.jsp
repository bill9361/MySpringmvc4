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
	<p>单文件上传：</p>
	<!-- 文件上传必须指定post方式 -->
	<form action="upload/singleFileUpload.do" method="post" enctype="multipart/form-data">
		<p>头像：<input type="file" name="headName"/></p>
		<p><input type="submit" value="上传"/></p>
	</form>
	<hr/>
	<p>多文件上传：</p>
	<!-- 文件上传必须指定post方式 -->
	<form action="upload/multipleFileUpload1.do" method="post" enctype="multipart/form-data">
		<p>文件1：<input type="file" name="fileName1"/></p>
		<p>文件2：<input type="file" name="fileName2"/></p>
		<p>文件3：<input type="file" name="fileName3"/></p>
		<p>文件4：<input type="file" name="fileName4"/></p>
		<p><input type="submit" value="上传"/></p>
	</form>
</body>
</html>
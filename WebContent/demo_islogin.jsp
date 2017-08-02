<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>upload</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/login.action"
		method="post">
		<input type="text" name="username" value="AAA"> 
		<input type="password" name="password" value="AAA"> 
		<input type="submit" value="提交">
	</form>
</body>
</html>
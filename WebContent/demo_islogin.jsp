<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>IS_LOGIN_TEST</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/islogin.action"
		method="post">
		<input type="text" name="username" value="aaa"> 
		<input type="password" name="password" value="aaa"> 
		<input type="submit" value="提交">
	</form>
</body>
</html>
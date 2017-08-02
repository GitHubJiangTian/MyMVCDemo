<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>upload</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/upload.action"method="post" enctype="multipart/form-data">
		<input type="file" name="upload_test"><br/>
		<input type="submit" value="upload test">
	</form>
	<br/>
	${result }
</body>
</html>
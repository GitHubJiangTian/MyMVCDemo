<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>REGISTRY</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/mysql_registry.action"
		method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username" value="aaa"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="userpwd" value="aaa"></td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td><input type="text" name="realname" value="realname1"></td>
			</tr>
			<tr>
			<tr>
				<td>余额</td>
				<td><input type="text" name="balance" value="9999.88"></td>
			</tr>
			<tr>
				<td><input type="submit" value="注册"></td>
				<td><input type="reset" value="重置" /></td>
			</tr>
		</table>

	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>SAVE_PAGE</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/product_save.action" method="post">
		<table>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="pname" value="Food"></td>
			</tr>
			<tr>
				<td>商品标识码</td>
				<td><input type="text" name="ean" value="F001"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="11.11"></td>
			</tr>
		</table>
		<input type="submit" value="确认增加">&nbsp;
		<input type="reset" value="重置信息">
	</form>
</body>
</html>
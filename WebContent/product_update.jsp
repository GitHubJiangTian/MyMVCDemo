<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>UPDATE_PAGE</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/product_update.action" method="post">
		<table border="1px">
			<tr>
				<td>商品编号</td>
				<td>${product.pid }<input type="hidden" name="pid" value="${product.pid }"></td>
			</tr>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="pname" value="${product.pname }"></td>
			</tr>
			<tr>
				<td>商品标识码</td>
				<td><input type="text" name="ean" value="${product.ean }"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="${product.price }"></td>
			</tr>
		</table>
		<input type="submit" value="确认更改">&nbsp;
		<input type="reset" value="重置信息">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>SHOW_PAGE</title>
</head>
<body>


	<table border="1px"
		style="text-align: center; background-color: silver;">
		<tr>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品编码</td>
			<td>商品价格</td>
			<td>商品操作</td>
		</tr>
		<c:forEach items="${productList }" var="product">
			<tr>
				<td>${product.pid }</td>
				<td>${product.pname }</td>
				<td>${product.ean }</td>
				<td>${product.price }</td>
				<td>
				<a href="${pageContext.request.contextPath }/product_delete.action?pid=${product.pid }">删除</a>
				<a href="${pageContext.request.contextPath }/product_findById.action?pid=${product.pid }&option=update">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<br />
	<form action="${pageContext.request.contextPath }/product_findById.action" method="post">
		<table>
			<tr>
				<td>PID:</td>
				<td><input type="text" name="pid" value="1"></td>
				<td><input type="submit" value="精确查找"></td>
			</tr>
		</table>
	</form>
	<br />
	<br />
	<br />
	<form action="${pageContext.request.contextPath }/product_findByName.action" method="post">
		<table>
			<tr>
				<td>PNAME：</td>
				<td><input type="text" name="pname" value="a"></td>
				<td><input type="submit" value="模糊查找"></td>
			</tr>
		</table>
	</form>
	<br />
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/product_save.jsp"><button>增加商品</button></a>

</body>
</html>
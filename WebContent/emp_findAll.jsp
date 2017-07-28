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
			<td>员工编号</td>
			<td>员工姓名</td>
			<td>员工职位</td>
			<td>员工上级</td>
			<td>员工入职日期</td>
			<td>员工工资</td>
			<td>员工奖金</td>
			<td>员工部门编号</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${EmpList }" var="emp">
			<tr>
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td>${emp.job }</td>
				<td>${emp.mgr }</td>
				<td>${emp.hiredate }</td>
				<td>${emp.sal }</td>
				<td>${emp.comm }</td>
				<td>${emp.deptno }</td>
				<td>
				<a href="${pageContext.request.contextPath }/emp_delete.action?empno=${emp.empno }">删除</a>
				<a href="${pageContext.request.contextPath }/emp_findById.action?empno=${emp.empno }&option=update">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<br />
	<form action="${pageContext.request.contextPath }/emp_findById.action" method="post">
		<table>
			<tr>
				<td>EMPNO:</td>
				<td><input type="text" name="empno" value="1001"></td>
				<td><input type="submit" value="精确查找"></td>
			</tr>
		</table>
	</form>
	<br />
	<br />
	<br />
	<form action="${pageContext.request.contextPath }/emp_findByName.action" method="post">
		<table>
			<tr>
				<td>ENAME：</td>
				<td><input type="text" name="ename" value="a"></td>
				<td><input type="submit" value="模糊查找"></td>
			</tr>
		</table>
	</form>
	<br />
	<br />
	<br />
	<a href="${pageContext.request.contextPath }/emp_save.jsp"><button>增加员工</button></a>

</body>
</html>
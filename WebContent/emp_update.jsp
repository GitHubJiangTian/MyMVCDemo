<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>UPDATE_PAGE</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/emp_update.action" method="post">
		<table>
			<tr>
				<td>员工编号</td>
				<td>${Emp.empno }<input type="hidden" name="empno" value="${Emp.empno }"></td>
			</tr>
			<tr>
				<td>员工姓名</td>
				<td><input type="text" name="ename" value="${Emp.ename }"></td>
			</tr>
			<tr>
				<td>员工职位</td>
				<td><input type="text" name="job" value="${Emp.job }"></td>
			</tr>
			<tr>
				<td>员工上级</td>
				<td><input type="text" name="mgr" value="${Emp.mgr }"></td>
			</tr>
			<tr>
				<td>员工入职日期</td>
				<td><input type="text" name="hiredate" value="${Emp.hiredate }"></td>
			</tr>
			<tr>
				<td>员工工资</td>
				<td><input type="text" name="sal" value="${Emp.sal }"></td>
			</tr>
			<tr>
				<td>员工奖金</td>
				<td><input type="text" name="comm" value="${Emp.comm }"></td>
			</tr>
			<tr>
				<td>员工部门编号</td>
				<td><input type="text" name="deptno" value="${Emp.deptno }"></td>
			</tr>
		</table>
		<input type="submit" value="确认更改">&nbsp;
		<input type="reset" value="重置信息">
	</form>
</body>
</html>
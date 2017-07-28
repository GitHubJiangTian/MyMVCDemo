<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>SAVE_PAGE</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/emp_save.action" method="post">
		<table>
			<tr>
				<td>员工编号</td>
				<td><input type="text" name="empno" value="FEEE"></td>
			</tr>
			<tr>
				<td>员工姓名</td>
				<td><input type="text" name="ename" value="SSSWE"></td>
			</tr>
			<tr>
				<td>员工职位</td>
				<td><input type="text" name="job" value="ACCCCR"></td>
			</tr>
			<tr>
				<td>员工上级</td>
				<td><input type="text" name="mgr" value="1333"></td>
			</tr>
			<tr>
				<td>员工入职日期</td>
				<td><input type="text" name="hiredate" value="2018-09-09"></td>
			</tr>
			<tr>
				<td>员工工资</td>
				<td><input type="text" name="sal" value="122"></td>
			</tr>
			<tr>
				<td>员工奖金</td>
				<td><input type="text" name="comm" value="112"></td>
			</tr>
			<tr>
				<td>员工部门编号</td>
				<td><input type="text" name="deptno" value="10"></td>
			</tr>
		</table>
		<input type="submit" value="确认增加">&nbsp;
		<input type="reset" value="重置信息">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>i18n</title>
<%@ taglib uri="/struts-tags" prefix="s" %>
</head>
<body>
	<a href="${pageContext.request.contextPath }/myi18n.action?request_locale=zh_CN">中文</a>
	<a href="${pageContext.request.contextPath }/myi18n.action?request_locale=en_US">English</a>
	
	<s:form action="#">
		<!-- key:访问的是国际化i18n资源文件中的内容 -->
		<s:textfield key="username"></s:textfield><br/>
		<s:password key="password"></s:password><br/>
		<s:submit key="submit"></s:submit>
	</s:form>
	<s:text name="welcome"></s:text>
</body>
</html>
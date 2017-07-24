<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>HELLO_PAGE</title>
</head>
<body>
<h1>Welcome ${sessionScope.username }!</h1>
<a href="${pageContext.request.contextPath }/ProductFindAllServlet"><button>查看所有商品</button></a>
<a href="${pageContext.request.contextPath }/product_save.jsp"><button>添加商品</button></a>
<a href="${pageContext.request.contextPath }/login.jsp"><button>登陆</button></a>
<a href="${pageContext.request.contextPath }/registry.jsp"><button>注册</button></a>
</body>
</html>
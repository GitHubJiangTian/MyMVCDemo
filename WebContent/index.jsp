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
<h2>EMP</h2>
<a href="${pageContext.request.contextPath }/emp_findAll.action"><button>查看所有员工</button></a>
<a href="${pageContext.request.contextPath }/emp_save.jsp"><button>添加员工</button></a>
<h2>PRODUCT</h2>
<a href="${pageContext.request.contextPath }/product_findAll.action"><button>查看所有商品（可能需要登陆，账户密码都为aaa）</button></a>
<br/>
<br/>
<a href="${pageContext.request.contextPath }/product_save.jsp"><button>添加商品（可能需要登陆，账户密码都为aaa）</button></a>
<br/>
<br/>
<a href="${pageContext.request.contextPath }/login.jsp"><button>登陆</button></a>
<a href="${pageContext.request.contextPath }/registry.jsp"><button>注册</button></a>
<h2>OTHER</h2>
<a href="${pageContext.request.contextPath }/demo_upload.jsp"><button>文件上传测试</button></a>
<a href="${pageContext.request.contextPath }/demo_i18n.jsp"><button>国际化测试</button></a>
<h2>IsLoginTest</h2>
<a href="${pageContext.request.contextPath }/demo_islogin.jsp"><button>登陆(权限登陆)</button></a>
<a href="${pageContext.request.contextPath }/registry.jsp"><button>注册（暂时无效）</button></a>
</body>
</html>
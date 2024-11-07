<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Failed!</h2>
	<h3>만약 관리자 회원가입했다면, 최고 관리자에게 승인요청하세요.</h3>
	<ul>
		<li><a href="<c:url value='/admin/createAccountForm' />">회원가입</a></li>
		<li><a href="<c:url value='/admin/loginForm' />">로그인</a></li>
	</ul>
</body>
</html>
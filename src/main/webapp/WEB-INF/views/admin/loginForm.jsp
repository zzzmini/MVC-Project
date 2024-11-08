<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" 
	value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript" src="${path}/resources/js/test.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>Log In</h2>
	<form action="<c:url value='/admin/loginConfirm'></c:url>"
		method="post" name="login_form">
		<input type="text" id="a_id" name="a_id" placeholder="Input Admin ID"/><br>
		<input type="password" id="a_pw" name="a_pw" placeholder="Input Admin PW"/><br>
		<input type="button" id="btn_login" value="login"/>
		<input type="reset" value="reset"/>
	</form>
</body>
</html>









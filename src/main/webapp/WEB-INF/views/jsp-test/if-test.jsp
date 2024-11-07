<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 선언부 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL if</title>
</head>
<body>
	<c:if test="true">
		true 이므로 실행한다.
	</c:if>
	<hr>
	<a href="/jstl/if?name=장원영&age=70">쿼리 호출</a>
	<br>
	이름 : ${param.name} <br>
	나이 : ${param.age }<br>
	<c:if test="${param.age > 19 && param.age < 40}">
		${param.name} 님은 청년입니다.
	</c:if>
</body>
</html>









<%@ page import="com.my.app.dto.CarDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	CarDTO car1 = new CarDTO("가1234", "소나타", 2000);
 	request.setAttribute("dto", car1);
%>
<h3>EL(Expression Language) 기본</h3>
	${dto.number }
<!-- 변수 출력 -->
<strong>1. CarDto instance에서 변수 model 출력</strong><br>
${dto} <br>
<hr>
</body>
</html>
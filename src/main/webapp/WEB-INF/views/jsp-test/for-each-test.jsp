<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	JSTL forEach 구문
	items : 대상 배열 또는 컬렉션<br>
	var : 요소 저장할 변수<br>
	varStatus : 내부인덱스 값
	<p>
	<hr>
	<table border="1">
		<tr>
			<th>count</th>
			<th>index</th>
			<th>name</th>
			<th>age</th>
		</tr>
		<c:forEach items="${dto }" var="ive" varStatus="order">
			<tr>
				<td>${order.count }</td>
				<td>${order.index }</td>
				<td>${ive.name }</td>
				<td>${ive.age }</td>
			</tr>
		</c:forEach>
	</table>
	<p>
	<hr>
	<h2>For-each로 반복횟수 정하기</h2>
	<c:forEach var="num" begin="1" end="5" >
		${num } &nbsp;
	</c:forEach>
</body>
</html>









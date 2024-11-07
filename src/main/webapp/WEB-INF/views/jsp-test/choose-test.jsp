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
	EL로 이름과 나이를 출력<br>
	이름 : ${dto.name } <br>
	나이 : ${dto.age }
	<hr>
	JSTL 다중 조건 choose, when, otherwise <br>
	<c:choose>
		<c:when test="${dto.name == '손흥민'}">
			손흥민님이 맞습니다.
			나이는 ${dto.age }세 입니다.
		</c:when>
		<c:when test="${dto.name == '아이유'}">
			아이유님이 맞습니다.
			나이는 ${dto.age }세 입니다.
		</c:when>
		<c:otherwise>
			${dto.name }님은 모르는 사람입니다.
		</c:otherwise>
	</c:choose>
	
</body>
</html>
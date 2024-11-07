<%@page import="com.my.app.dto.AdminDTO"%>
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
<%
	AdminDTO adminLoginedDto = (AdminDTO)
						session.getAttribute("adminLoginedDto");
	if(adminLoginedDto != null){
		// 로그인 된 후 처리 내용
		// html 내용
%>
	<ul>
		<li><a href='<c:url value="/admin/logoutConfirm"></c:url>'>로그아웃</a></li>
		<li><a href='<c:url value="/admin/modifyAccountForm" />'>정보수정</a></li>
		<c:if test="${adminLoginedDto.a_id eq 'admin'}">
			<li><a href='<c:url value="/admin/adminList"></c:url>'>
					관리자목록</a></li>
		</c:if>
		<li><a href="#">전체도서</a></li>
		<li><a href="#">도서등록</a></li>
	</ul>
<%
	} else {
		// 로그인 전
		// html 내용
%>
	<ul>
		<li><a href='<c:url value="/admin/createAccountForm"></c:url>'>회원가입</a></li>
		<li><a href='<c:url value="/admin/loginForm" />'>로그인</a></li>
	</ul>
<%
	}
%>
</body>
</html>
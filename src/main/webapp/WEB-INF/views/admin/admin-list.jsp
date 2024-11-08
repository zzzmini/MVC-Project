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
	<c:import url="nav.jsp"></c:import>
	<h3>ADMIN LIST</h3>
	<table border="1">
		<tr>
			<th>계정</th>
			<th>이름</th>
			<th>연락처</th>
			<th>승인</th>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.a_id}</td>
				<td>${dto.a_name}</td>
				<td>${dto.a_phone}</td>
				<td><c:choose>
						<c:when test="${dto.a_approval eq 0 }">
							<c:url value="/admin/setAdminApproval" var="approval_url">
								<c:param name="id" value="${dto.a_id }"></c:param>
							</c:url>
							<a href="${approval_url}">승인처리</a>
						</c:when>
						<c:when test="${dto.a_approval eq 1 }">
							<c:out value="승인완료"></c:out>
						</c:when>
					</c:choose></td>
			</tr>
		</c:forEach>

	</table>
	<div>
		<c:choose>
			<c:when test="${paging.page <= 1}">
				<span>[이전]</span>
			</c:when>
			<c:otherwise>
				<a href="/admin/pagingList?page=${paging.page -1}">[이전]</a>
			</c:otherwise>
		</c:choose>
		
		<c:forEach var="i" begin="${paging.startPage }" 
							end="${paging.endPage }" step="1">
			<c:choose>
				<c:when test="${i eq paging.page }">
					<span>${i}</span>
				</c:when>
				<c:otherwise>
					<a href="/admin/pagingList?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${paging.page >= paging.maxPage}">
				<span>[다음]</span>
			</c:when>
			<c:otherwise>
				<a href="/admin/pagingList?page=${paging.page+1}">[다음]</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>







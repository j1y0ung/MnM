<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 페이지</title>
</head>
<body>
<h2>내가 등록한 물품 목록</h2>
<table border="1">
	<tr>
		<td>상품명</td>
		<td>등록날짜</td>
		<td>경매기능 여부</td>
		<td>판매여부</td>
	</tr>
	<c:forEach var="personalDealItem" items="${personalDealItemList.pageList}">
		<tr>
			<td>
				<a href='<c:url value="/personalDeal/viewItemDetail.do">
				<c:param name="personalDealId" value="${personalDealItem.personalDealId}"/></c:url>'>
           		<c:out value="${personalDealItem.title}" /></a>
        		<!-- 상품명 클릭시 파라미터로 상품id 넘겨줌 -->
			</td>
			<td>
				<c:out value="${personalDealItem.regiDate}" />
			</td>
			<td>
				<c:out value="${personalDealItem.type}" />
			</td>
			<td>
				<c:out value="${personalDealItem.dealStatus}" />
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td>
			<c:if test="${!personalDealItemList.firstPage}">
				<a href='<c:url value="/personalDeal/viewItemList.do">
				<c:param name="page" value="previous"/></c:url>'>
				&lt;&lt; Prev</a>
			</c:if> 
			<c:if test="${!personalDealItemList.lastPage}">
				<a href='<c:url value="/personalDeal/viewItemList.do">
				<c:param name="page" value="next"/></c:url>'>
				Next &gt;&gt;</a>
			</c:if>
		</td>
	</tr>
</table>
</body>
</html>
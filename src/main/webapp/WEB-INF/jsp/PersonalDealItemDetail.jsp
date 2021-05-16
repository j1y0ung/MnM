<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 상품 상세정보</title>
</head>
<body>
${personalDealItem.productid}
<table border="1">
	<tr>
		<td>이미지</td>
		<td>제목</td>
		<td>판매희망가</td>
		<td>상품상태</td>
		<td>배송비</td>
		<td>판매자 아이디</td>
		<td>거래지역</td>
		<td>조회수</td>
	</tr>
	<tr>
		<td><c:out value="${personalDealItem.img}" /></td>
		<td><c:out value="${personalDealItem.title}" /></td>
		<td><c:out value="${personalDealItem.price}" /></td>
		<td><c:out value="${personalDealItem.dealStatus}" /></td>
		<td><c:out value="${personalDealItem.shippingFee}" /></td>
		<td><c:out value="${personalDealItem.userid}" /></td>
		<td><c:out value="${personalDealItem.location}" /></td>
		<td><c:out value="${personalDealItem.views}" /></td>
	<tr>
	<tr>
		<td><button type="button">구매하기</button></td>
		<td><button type="button">장바구니</button></td>
	</tr>
</table>

</body>
</html>
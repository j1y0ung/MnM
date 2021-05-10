<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>경매 내역</title>
</head>
<body>

<br><h1>내가 판매한 물품</h1><br>
	<c:forEach var="auctionItem" items="${auctionItemList.pageList}">
		<tr>
			<td><img src=""/></td>
			<td>
				<a href='<c:url value="/"><c:param name="title" value="${auctionItem.title}"/></c:url>'></a>
				<c:out value="${auctionItem.title}" />
			</td>
		</tr>
	</c:forEach>
	
<br><h1>내가 입찰한 물품</h1><br>
<c:forEach var="auctionItem" items="${auctionItemList.pageList}">
		<tr>
			<td><img src=""/></td>
			<td>
				<a href='<c:url value="/"><c:param name="title" value="${auctionItem.title}"/></c:url>'></a>
				<c:out value="${auctionItem.title}" />
			</td>
		</tr>
	</c:forEach>

<br><h1>내가 낙찰받은 물품</h1><br>
<c:forEach var="auctionItem" items="${auctionItemList.pageList}">
		<tr>
			<td><img src=""/></td>
			<td>
				<a href='<c:url value="/"><c:param name="title" value="${auctionItem.title}"/></c:url>'></a>
				<c:out value="${auctionItem.title}" />
			</td>
		</tr>
	</c:forEach>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>경매 물품 목록</title>
</head>
<body>
<table>
	<c:forEach var="auctionItem" items="${auctionItemList.pageList}">
		<tr>
			<td><img src=""/></td>
			<td>
				<a href='<c:url value="/"><c:param name="title" value="${auctionItem.title}"/></c:url>'></a>
				<c:out value="${auctionItem.title}" />
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
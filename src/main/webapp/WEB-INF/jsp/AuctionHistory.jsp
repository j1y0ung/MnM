<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��� ����</title>
</head>
<body>

<br><h1>���� �Ǹ��� ��ǰ</h1><br>
	<c:forEach var="auctionItem" items="${auctionItemList.pageList}">
		<tr>
			<td><img src=""/></td>
			<td>
				<a href='<c:url value="/"><c:param name="title" value="${auctionItem.title}"/></c:url>'></a>
				<c:out value="${auctionItem.title}" />
			</td>
		</tr>
	</c:forEach>
	
<br><h1>���� ������ ��ǰ</h1><br>
<c:forEach var="auctionItem" items="${auctionItemList.pageList}">
		<tr>
			<td><img src=""/></td>
			<td>
				<a href='<c:url value="/"><c:param name="title" value="${auctionItem.title}"/></c:url>'></a>
				<c:out value="${auctionItem.title}" />
			</td>
		</tr>
	</c:forEach>

<br><h1>���� �������� ��ǰ</h1><br>
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
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>입찰 현황</title>
</head>
<body>
<br><h1 align="center">입찰 현황</h1><br>
<br><h3 align="center">${auctionItem.title}</h3><br>

	<div class="row">
      <button type="button" class="btn btn-primary float-right" onClick="">최고가 낙찰하기</button><br><br>
    </div>
    
<table>
	<tr>
		<td>입찰일시</td>
		<td>입찰자</td>
		<td>금액</td>
	</tr>
	
<c:forEach var="myItem" items="${auctionItem.pageList}">
	<tr>
		<td>
			<a href='<c:url value="/"><c:param name="title" value="${auctionItem.title}"/></c:url>'></a>
			<c:out value="${auctionItem.date}" />
		</td>
		<td><c:out value="${auctionItem.userId}" /></td>
		<td><c:out value="${auctionItem.bidPrice}" /></td>
	</tr>
</c:forEach>
</table>

</body>
</html>
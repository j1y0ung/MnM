<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>입찰하기</title>
</head>
<body>
<br><h1 align="center">입찰하기</h1><br>
<br><h3 align="center">${auctionItem.title}</h3><br>

<div align="center">
<form:form modelAttribute="auctionForm" method="post">
  <form:errors cssClass="error" /> <br><br>
  
  <table id="auctionItem">
	<tr>
		<td>판매자:</td>
         <td> ${auctionItem.bidInfo}</td>
	</tr>
	<tr>
		<td>마감일자:</td>
        <td> ${auctionItem.endDate}</td>
	</tr>
	<tr>
		<td>입찰단위:</td>
        <td> ${auctionItem.bidUnit}원</td>
	</tr>
	<tr>
		<td>현재가: ${auctionItem.currentPrice}원</td>
	</tr>
	<tr>
           <td>입찰금액:</td>
           <td>
           <form:password path="auctionItem.bidPrice" /> 
           <B><form:errors path="auctionItem.bidPrice" cssClass="error" /></B>원</td>
           <td>
			<a href='<c:url value="/auction/bidding.do">
            <c:param name="itemId" value="${item.itemId}"/></c:url>'>입찰하기</a>
           </td>
    </tr>
   </table>
  <br />
</form:form>
</div>

</body>
</html>
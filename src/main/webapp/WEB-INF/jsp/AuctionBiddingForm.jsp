<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�����ϱ�</title>
</head>
<body>
<br><h1 align="center">�����ϱ�</h1><br>
<br><h3 align="center">${auctionItem.title}</h3><br>

<div align="center">
<form:form modelAttribute="auctionForm" method="post">
  <form:errors cssClass="error" /> <br><br>
  
  <table id="auctionItem">
	<tr>
		<td>�Ǹ���:</td>
         <td> ${auctionItem.bidInfo}</td>
	</tr>
	<tr>
		<td>��������:</td>
        <td> ${auctionItem.endDate}</td>
	</tr>
	<tr>
		<td>��������:</td>
        <td> ${auctionItem.bidUnit}��</td>
	</tr>
	<tr>
		<td>���簡: ${auctionItem.currentPrice}��</td>
	</tr>
	<tr>
           <td>�����ݾ�:</td>
           <td>
           <form:password path="auctionItem.bidPrice" /> 
           <B><form:errors path="auctionItem.bidPrice" cssClass="error" /></B>��</td>
           <td>
			<a href='<c:url value="/auction/bidding.do">
            <c:param name="itemId" value="${item.itemId}"/></c:url>'>�����ϱ�</a>
           </td>
    </tr>
   </table>
  <br />
</form:form>
</div>

</body>
</html>
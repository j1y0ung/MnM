<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>

<body>
	<table>
		<tr>
			<td style="text-align:left">
				<a href="<c:url value="/"/>"><img border="0" src="/images/mnm_logo.png" width="150" /></a>
			</td>
			<td style="text-align:right">
				<c:if test="${empty session.account}" ><a href="<c:url value="/login"/>">login</a></c:if>
				<c:if test="${empty session.account}" ><a href="<c:url value="/join"/>">join</a></c:if>
				<c:if test="${!empty session.account}" ><a href="<c:url value="/logout"/>">logout</a></c:if>
				<c:if test="${!empty session.account}" ><a href="<c:url value="/cart"/>">cart</a></c:if>
				<c:if test="${!empty session.account}" ><a href="<c:url value="/auction/viewCart.do"/>">auction cart</a></c:if>
				<c:if test="${!empty session.account}" ><a href="<c:url value="/mypage"/>">mypage</a></c:if>
			</td>
		</tr>
		<tr>
			<td>
				<a href="<c:url value="/personalDeal/list"/>">PersonalDeal</a>
				&nbsp&nbsp<img border="0" src="/images/separator.gif" />&nbsp&nbsp
				<a href="<c:url value="/auction/recently"/>">Auction</a>
				&nbsp&nbsp<img border="0" src="/images/separator.gif"/>&nbsp&nbsp
				<a href="<c:url value="/crowdFunding/list"/>">CrowdFunding</a>
			</td>
		</tr>
	</table>
</body>
</html>
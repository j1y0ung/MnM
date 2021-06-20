<%@page import="com.example.mnm.domain.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	Account account = (Account)session.getAttribute("account");
%>
<c:set var="account" value="<%=account %>"/>
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
				<c:if test="${account == null}" ><a href="<c:url value="/login"/>">login</a></c:if>
				<c:if test="${account == null}" ><a href="<c:url value="/join"/>">join</a></c:if>
				<c:if test="${account != null}" ><a href="<c:url value="/logout"/>">logout</a></c:if>
				<c:if test="${account != null}" ><a href="<c:url value="/cart"/>">cart</a></c:if>
				<c:if test="${account != null}" ><a href="<c:url value="/mypage"/>">mypage</a></c:if>
				<!-- <a href="<c:url value="/sessionCheck"/>">checkSession(log확인)</a>-->
			</td>
		</tr>
		<tr>
			<td>
				<a href="<c:url value="/personalDeal/newest"/>">PersonalDeal</a>
				&nbsp&nbsp<img border="0" src="/images/separator.gif" />&nbsp&nbsp
				<a href="<c:url value="/auction/recently"/>">Auction</a>
				&nbsp&nbsp<img border="0" src="/images/separator.gif"/>&nbsp&nbsp
				<a href="<c:url value="/crowdFunding/list"/>">CrowdFunding</a>
			</td>
		</tr>
	</table>
	<hr>
</body>
</html>
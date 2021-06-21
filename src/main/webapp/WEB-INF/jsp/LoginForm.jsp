<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:eval expression="@environment.getProperty('server.port')" var="portNum" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>LoginForm</title>
</head>

<body>
<div align="center">
<jsp:include page="header.jsp" flush="false"/>
<table>
	<tr>
		<td>
			<form:form modelAttribute="login" method="post" action="/login">
				<c:if test="${!empty signonForwardAction}">
			      <input type="hidden" name="forwardAction"
			        value='<c:url value="${signonForwardAction}"/>' />
			    </c:if>
				<form:label path="userId">id</form:label>
				<form:input path="userId"></form:input>
				<form:errors path="userId"/>
				<br>
				<form:label path="pwd">pwd</form:label>
				<form:input path="pwd"></form:input>
				<form:errors path="pwd"/>
				<br>
				<input type="submit" value="로그인"/>
			</form:form>
			<a href="https://kauth.kakao.com/oauth/authorize?
			response_type=code&client_id=7f2d0803ec4cb51e879b3e59579f6fe1&
			redirect_uri=http://localhost:8080/kakaoLogin">
				<img width="110" src="/images/kakao_login_medium_narrow.png"/>
			</a>
		</td>
	</tr>
</table>
<jsp:include page="footer.jsp" flush="false"/>
</div>
</body>
</html>
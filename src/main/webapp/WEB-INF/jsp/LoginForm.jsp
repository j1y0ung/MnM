<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>LoginForm</title>
</head>

<body>
<table>
	<tr>
		<td>
			<jsp:include page="header.jsp" flush="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<form:form modelAttribute="login">
				<form:label path="userId">id</form:label>
				<form:input path="userId"></form:input><br>
				<form:label path="pwd">pwd</form:label>
				<form:input path="pwd"></form:input><br>
				<input type="submit" value="로그인"/>
			</form:form>
			<a href="https://kauth.kakao.com/oauth/authorize?
			response_type=code&client_id=7f2d0803ec4cb51e879b3e59579f6fe1&
			redirect_uri=http://localhost:8088/kakaoLogin">
				<img width="110" src="/images/kakao_login_medium_narrow.png"/>
			</a>
		</td>
	</tr>
	<tr>
		<td>
			<jsp:include page="footer.jsp" flush="false"/>
		</td>
	</tr>
</table>
</body>
</html>
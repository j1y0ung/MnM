<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<title>펀딩 등록 내역</title>
</head>
<body>
<br><h1 align="center">펀딩 등록 내역</h1><br>
<table th:unless="${#lists.isEmpty()}">
	<tr>
		<th>이미지</th><th>펀딩 간단 설명</th>
	</tr>
	<tr th:each=" : ${}">
		<td th:text="${}">이미지</td>
		<td th:text="${}">펀딩 간단 설명</td>
	</tr>
</table>
</body>
</html>
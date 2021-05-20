<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<title>펀딩 아이템 목록</title>
</head>
<body>
<br><h1 align="center">펀딩 아이템 목록</h1><br>
<a href="" th:href="@{}" class="btn btn-primary">펀딩 등록하기</a><br><br>
카테고리: <select class="form-select form-select-sm" th:field="*{category}">
  			<option th:each="category : ${categories}"
  					th:value="${category}"
  					th:text="">카테고리</option>
		</select>
정렬: <select class="form-select form-select-sm" th:field="*{sort}">
			<option th:each="sort : ${sorts}"
					th:value="${sort}"
  					th:text="">정렬</option>
		</select>
<hr>
<div th:unless="${#lists.isEmpty()}">
	<ul th:each=" : ${}">
		<li th:text="${}">이미지</li>
		<li th:text="${}">D-00</li>
		<li th:text="${}">카테고리</li>
		<li th:text="${}">창작자</li>
		<li th:text="${}">제목</li>
		<li th:text="${}">~% 달성</li>
		<a href="" th:href="@{}" class="btn btn-primary">상세 정보 보기</a><br><br>
	</ul>
</div>
</body>
</html>
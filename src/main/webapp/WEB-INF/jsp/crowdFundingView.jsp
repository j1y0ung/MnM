<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<title>펀딩 상세 화면</title>
</head>
<body>
<br><h1 align="center">펀딩 아이템 상세 화면</h1><br>
<div class="container">
  <div class="row">
  	<hr>
    <h1>펀딩 제목: <span th:text="${crowdFundingItem.title}"></span></h1>
  </div>	
  <div class="row">
    <div class="col">
      <img src="" alt="대표 사진">
    </div>
    <div class="col">
      <p>모인 금액: <span th:text="${crowdFundingItem.currentSponsoredAmount}"></span></p>
      <p>마감일: <span th:text="${crowdFundingItem.closingDate}"></span></p>
      <p>후원자 인원: <span th:text="${crowdFundingItem.numberOfSponsor}"></span></p>
      <p>프로젝트 간단 요약 내용: <span th:text="${crowdFundingItem.shortInfo}"></span></p>
      <input type="submit" class="btn btn-primary btn-lg" value="펀딩하기" th:value="#{}"><br><br>
    </div>
    <hr>
    <div class="row">
    <p>펀딩 상세 내용: <span th:text="${crowdFundingItem.detailInfo}"></span></p>
  </div>
  </div>
</div>
</body>
</html>
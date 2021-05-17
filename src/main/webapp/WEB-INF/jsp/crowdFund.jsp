<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<title>펀딩하기</title>
</head>
<body>
<br><h1 align="center">펀딩하기</h1><br>
<div class="container">
  <div class="row">
     <p>(일반 상품 주문이랑 같은 화면)</p>
   </div>
    <div class="row">
      <input type="submit" class="btn btn-primary" value="결제하기" th:value="#{}"><br><br>
    </div>
    <hr>
  </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 상품 등록</title>
</head>
<body>
<h2>물품 정보를 입력해 주세요</h2>
<form:form modelAttribute="personalDealItemInfo">
	<p>
		<form:label path="title">물품명</form:label>
		<form:input path="title" />
	</p>
	<p>
		<form:label path="price">판매희망가</form:label>
		<form:input path="price" />
	</p>
	<p>
		<form:label path="condition">상품상태</form:label>
		<form:input path="condition" />
	</p>
	<p>
		<form:label path="shippingFee">배송비</form:label>
		<form:input path="shippingFee" />
	</p>
	<p>
		<form:label path="location">거래지역</form:label>
		<form:input path="location" />
	</p>
	<p>
		<form:label path="description">상세 설명</form:label>
		<form:input path="description" />
	</p>
	<p>
		<form:label path="category">카테고리</form:label>
		<form:select path="category" >
			<option value="">--- 선택 ---</option>
			<form:options items="${categories}" itemLabel="label" itemValue="cate" />
		</form:select>
	</p>
	<p>
		<input type="submit" value="상품 등록">
	</p>
</form:form>
</body>
</html>
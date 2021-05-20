<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경매 상품 등록</title>
</head>
<body>
<h2>경매 상품 정보를 입력해 주세요</h2>
<form:form modelAttribute="auctionItemInfo">
	<p>
		<form:label path="category">카테고리</form:label>
		<form:select path="category" >
			<option value="">--- 선택 ---</option>
			<form:options items="${categories}" itemLabel="label" itemValue="cate" />
		</form:select>
	</p>
	<p>
		<form:label path="title">이미지</form:label>
		<input type="file" name="img" accept="image/*" />
	</p>
	<p>
		<form:label path="title">상품명</form:label>
		<form:input path="title" />
	</p>
	<p>
		<form:label path="description">상세 설명</form:label>
		<form:input path="description" />
	</p>
	<p>
		<form:label path="startPrice">경매 시작가</form:label>
		<form:input path="startPrice" />
	</p>
	<p>
		<form:label path="bidUnit">입찰 단위</form:label>
		<form:input path="bidUnit" />
	</p>
	<p>
		<form:label path="immdPurchasePrice">즉시 구매가</form:label>
		<form:input path="immdPurchasePrice" />
	</p>
	<p>
		<form:label path="startDate">경매 시작일</form:label>
		<input type='date' name='startDate' value='--년--월--일'/>
	</p>
	<p>
		<form:label path="endDate">경매 마감일</form:label>
		<input type='date' name='endDate' value='--년--월--일'/>
	</p>
	<p>
		<input type="submit" value="상품 등록">
	</p>
</form:form>
</body>
</html>
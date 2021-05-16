<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>

<script>
// 대분류 옵션 선택에 따라 중분류 옵션 목록 바뀌도록 함
function changeGroup2(op) {
	var group2_elec = ["TV", "컴퓨터", "스마트폰"];
	var group2_clot = ["상의", "하의", "신발", "악세서리"];
	var group2_food = ["빵", "과자", "음료"];
	
	var target = document.getElementById("group2");
	if(op.value == "electronics") {
		var g2 = group2_elec;
	}
	else if(op.value == "clothes") {
		var g2 = group2_clot;
	}
	else if(op.value == "foods") {
		var g2 = group2_food;
	}
	target.options.length = 0;
	
	for(x in g2) {
		var opt = document.createElement("option");
		switch(g2[x]) {
		
		case "TV":
			opt.value = "tv";
			break;
		case "컴퓨터":
			opt.value = "comp";
			break;
		case "스마트폰":
			opt.value = "smartp";
			break;
		case "상의":
			opt.value = "top";
			break;
		case "하의":
			opt.value = "bottom";
			break;
		case "신발":
			opt.value = "shoes";
			break;
		case "악세서리":
			opt.value = "acc";
			break;
		case "빵":
			opt.value = "bread";
			break;
		case "과자":
			opt.value = "snack";
			break;
		case "음료":
			opt.value = "drink";
			break;
		}
		opt.innerHTML = g2[x];
		target.appendChild(opt);
	}
}
</script>
</head>

<body>
<form action="/personalDeal/searchByKeyword.do" method="post">
	<input type="text" name="keyword">
	<button>검색</button>
</form>

<form name="f">
	<select id="group1" onchange="changeGroup2(this)">
	    <option value="">--대분류--</option>
	    <option value="electronics">전자제품</option>
	    <option value="clothes">옷</option>
	    <option value="foods">식품</option>
	</select>
	<select id="group2">
	    <option>--중분류--</option>
	</select>
	가격: <input type="text" name="priceMin" size="5">원 ~ <input type="text" name="priceMax" size="5">원
	<button>검색</button>
</form>

<h2>상품 목록</h2>
<table border="1">
	<tr>
		<td>Product Image</td>
		<td>Name</td>
	</tr>
	<c:forEach var="personalDealItem" items="${personalDealItemList.pageList}">
		<tr>
			<td>
				<c:out value="${personalDealItem.img}" />
			</td>
			<td>
				<a href='<c:url value="/personalDeal/viewItemDetail.do">
				<c:param name="personalDealId" value="${personalDealItem.personalDealId}"/></c:url>'>
           		<c:out value="${personalDealItem.title}" /></a>
        		<!-- 상품명 클릭시 파라미터로 상품id 넘겨줌 -->
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td>
			<c:if test="${!personalDealItemList.firstPage}">
				<a href='<c:url value="/personalDeal/viewItemList.do">
				<c:param name="page" value="previous"/></c:url>'>
				&lt;&lt; Prev</a>
			</c:if> 
			<c:if test="${!personalDealItemList.lastPage}">
				<a href='<c:url value="/personalDeal/viewItemList.do">
				<c:param name="page" value="next"/></c:url>'>
				Next &gt;&gt;</a>
			</c:if>
		</td>
	</tr>
</table>
</body>
</html>
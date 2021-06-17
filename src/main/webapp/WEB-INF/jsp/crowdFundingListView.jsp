<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorator="layout/default_layout">

<!-- index.html 고유 CSS 추가 -->
<th:block layout:fragment="css">
	<link rel="stylesheet" th:href="@{/css/page/home.css}" >
</th:block>
    
<!-- index.html 고유 스크립트 추가 -->
<th:block layout:fragment="script">
	<script th:src="@{/js/page/home.js}"></script>
</th:block>

<div layout:fragment="content">
	<h1 align="center">펀딩 아이템 목록</h1>
	<a href="#" th:href="@{/crowdFunding/add}" class="btn btn-primary">펀딩 등록하기</a> 
	<table>
		<tr>
			<td>
				카테고리: 
				<select class="form-select form-select-sm" th:field="*{categories}">
					<option th:each="category : ${categories}" th:value="${category}" th:text="${category.catName}">카테고리</option>
				</select> 
				
				<label>상위 카테고리</label>:
				<select class="category1" id="category1" name="category1">
					<option value="">전체</option>
				</select> 
				<label>하위 카테고리</label>:
				<select class="category2" id="category2" name="category2">
					<option value="">전체</option>
				</select>
			</td>
			<td>
				정렬: 
				<select class="form-select form-select-sm" th:field="*{sorts}">
					<option th:each="sort : ${sorts}" th:value="${sort}" th:text="${sort}">정렬</option>
				</select>
			</td>
			<td>
				
			</td>
		</tr>
	</table>
	<hr>
	<%-- <div th:unless="${#lists.isEmpty(crowdFundingItemList)}">
		<ul th:each="crowdFundingItem : ${crowdFundingItemList.pageList}">
			<li th:text="${crowdFundingItem.item.img}" /></li>
			<li th:text="'D-' + ${#dates.day(crowdFundingItem.closingDate)-#dates.day(#dates.createNow())}"></li>
			<li th:text="${crowdFundingItem.item.product.category.catName}">카테고리</li>
			<li th:text="'창작자 : ' + ${crowdFundingItem.item.account.name}">창작자</li>
			<li th:text="'제목 : ' + ${crowdFundingItem.item.title}">제목</li>
			<li th:text="((${crowdFundingItem.currentSponsoredAmount} / ${crowdFundingItem.targetAmount}) * 100) + '% 달성'">~% 달성</li>
			<li><a href="" th:href="@{/crowdFunding/item(crowdFundingId=${crowdFundingItem.crowdFundingId})}" class="btn btn-primary">상세 정보 보기</a></li>
		</ul>
	</div> --%>
	<!-- <div>
		<a th:if="${!crowdFundingItemList.firstPage}"
       		th:href="?page=previous">Previous</a>
       <span th:text="${crowdFundingItemList.page + 1}">1 / 4</span>
      	<a th:if="${!crowdFundingItemList.lastPage}"
            th:href="@{/crowdFunding/list?page=next}">Next</a>
	</div> -->

<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
crossorigin="anonymous"></script>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script>
// 컨트롤러에서 데이터 받기
var jsonData = JSON.parse('${categoryList}');
console.log(jsonData);

var cate1Arr = new Array();
var cate1Obj = new Object();

// 1차 분류 셀렉트 박스에 삽입할 데이터 준비
for(var i = 0; i < jsonData.length; i++) {
 
 if(jsonData[i].level == "1") {
  cate1Obj = new Object();  //초기화
  cate1Obj.catId = jsonData[i].catId;
  cate1Obj.catName = jsonData[i].catName;
  cate1Arr.push(cate1Obj);
 }
}

// 1차 분류 셀렉트 박스에 데이터 삽입
var cate1Select = $("select.category1")

for(var i = 0; i < cate1Arr.length; i++) {
 cate1Select.append("<option value='" + cate1Arr[i].catId + "'>"
      + cate1Arr[i].catName + "</option>"); 
}
$(document).on("change", "select.category1", function(){

	 var cate2Arr = new Array();
	 var cate2Obj = new Object();
	 
	 // 2차 분류 셀렉트 박스에 삽입할 데이터 준비
	 for(var i = 0; i < jsonData.length; i++) {
	  
	  if(jsonData[i].level == "2") {
	   cate2Obj = new Object();  //초기화
	   cate2Obj.catId = jsonData[i].catId;
	   cate2Obj.catName = jsonData[i].catName;
	   cate2Obj.catIdRef = jsonData[i].catIdRef;
	   
	   cate2Arr.push(cate2Obj);
	  }
	 }
	 
	 var cate2Select = $("select.category2");
	 
	 cate2Select.children().remove();

	 $("option:selected", this).each(function(){
	  
	  var selectVal = $(this).val();  
	  cate2Select.append("<option value=''>전체</option>");
	  
	  for(var i = 0; i < cate2Arr.length; i++) {
	   if(selectVal == cate2Arr[i].catIdRef) {
	    cate2Select.append("<option value='" + cate2Arr[i].catId + "'>"
	         + cate2Arr[i].catName + "</option>");
	   }
	  }
	  
	 });
	 
	});
</script>
</html>
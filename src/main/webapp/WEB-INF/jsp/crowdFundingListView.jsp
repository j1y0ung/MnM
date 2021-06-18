<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<head>
	<title>펀딩 아이템 목록</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous"
>
</head>
<body>

<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

<br><h1 align="center">펀딩 아이템 목록</h1><br>

<div align="center"><a href="${path}/crowdFunding/add" class="btn btn-primary">펀딩 등록하기</a></div>
	
<hr>
<div align="right">
<table>
<tr>
<td>
	<a href="${path}/crowdFunding/recently">최신순</a>&nbsp;
</td>
<td>
	<a href="${path}/crowdFunding/mostViews">인기순</a>&nbsp;
</td>
<td>
	<a href="${path}/crowdFunding/mostSponsors">최다 후원순</a>&nbsp;
</td>
<td>
	<a href="${path}/crowdFunding/mostAmount">최다 금액순</a>&nbsp;
</td>
<td>
	<a href="${path}/crowdFunding/deadline">마감 임박순</a>
</td>
<td>
<form:form commandName="Category" action="/crowdFunding/category" method="post" enctype="multipart/form-data">
		<label>상위 카테고리</label>:
		<select class="category1" id="category1" name="category1">
			<option value="">전체</option>
		</select>
		&nbsp; 
		<label>하위 카테고리</label>:
		<select class="category2" id="category2" name="category2">
			<option value="">전체</option>
		</select>
	<input type="submit" class="btn btn-primary" value="카테고리 별로 보기">
</form:form>
</td>
</tr>
</table>
</div>	
<hr>
<div>
<c:choose>
    <c:when test="${fn:length(crowdFundingItemList) == 0}">
        조회결과가 없습니다.
    </c:when>
    <c:otherwise>		
		<c:forEach var="crowdFundingItem" items="${crowdFundingItemList}">
		<ul>
			<li><c:out value="${crowdFundingItem.item.img}" /></li>
			<li>마감일 : <c:out value="${crowdFundingItem.closingDate}" /></li>
			<li>카테고리 : <c:out value="${crowdFundingItem.item.category.catName}" /></li>
			<li>창작자 : <c:out value="${crowdFundingItem.item.account.userid}" /></li>
			<li>제목 : <c:out value="${crowdFundingItem.item.title}" /></li>
			<li>달성 금액 : <c:out value="${crowdFundingItem.currentSponsoredAmount}" /></li>
			<li><a href="${path}/crowdFunding/item/${crowdFundingItem.crowdFundingId}" class="btn btn-primary">상세 정보 보기</a></li>
		</ul>
		</c:forEach>
	</c:otherwise> 
</c:choose>
</div> 
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>

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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>
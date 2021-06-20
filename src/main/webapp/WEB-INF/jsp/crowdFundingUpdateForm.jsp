<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<title>펀딩 수정 화면</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

<div class="container">
<br><h1 align="center">펀딩 아이템 수정하기</h1><br>
	<div class="row-lg-10">
		<form:form action="/crowdFunding/update" modelAttribute="crowdFundingItem" method="post" enctype="multipart/form-data">
		<div class="row-lg-10">
            <div class="form-group">
            	<form:hidden path="item.account.userid"></form:hidden>
            	<form:hidden path="crowdFundingId"></form:hidden>
            	<form:hidden path="item.itemId"></form:hidden>
				<p>
					<form:label path="item.title">제목</form:label>:<br>
					<form:input path="item.title" />
	    		</p>
            </div>
		  </div>
		  <div class="row-lg-10">
            <div class="form-group">
            	<p>
            		<form:label path="item.img">대표 이미지</form:label>:<br>
					<form:input path="item.img" />
				</p>
            </div> 
		  </div>
		  <div class="row-lg-10">
           <div class="row-lg-10">
	           <label>상위 카테고리</label>:
					<select class="category1" id="category1" name="category1">
						<option value="">전체</option>
					</select>
				&nbsp; 
				<label>하위 카테고리</label>:
					<select class="category2" id="category2" name="category2">
						<option value="">전체</option>
					</select>
		  </div>
		  </div>
		  <div class="row-lg-10">
            <div class="form-group">
            	<p>
			        <form:label path="shortInfo">프로젝트 요약</form:label>:<br>
					<form:input path="shortInfo" />
	    		</p>
            </div>
		  </div>
		  <div class="row-lg-10">
            <div class="form-group">
            	<p>
			       <form:label path="item.description">프로젝트 상세내용</form:label>:<br>
					<form:textarea path="item.description" rows="20" />
	    		</p>
            </div>
		  </div>
		  <hr>
		  <div class="row-lg-10">
            <div class="form-group">
            	<p>
			       <form:label path="targetAmount">목표 금액</form:label>:<br>
					<form:input path="targetAmount" />
	    		</p>
            </div>
		  </div>
		  <div class="row-lg-10">
            <div class="form-group">
                <p>
			        <form:label path="startDate">펀딩 시작일</form:label>:<br>
					<input type="date" id="startDate" name="startDate" value="${startDate}" />
	    		</p>
            </div>
		  </div>
		  <div class="row-lg-10">
            <div class="form-group">
                <p>
			        <form:label path="closingDate">펀딩 종료일</form:label>:<br>
					<input type="date" id="closingDate" name="closingDate" value="${closingDate}" />
	    		</p>
            </div>
		  </div>
		  <div class="row-lg-10">
            <div class="form-group">
            	<p>
			        <form:label path="productComposition">상품 구성</form:label>:<br>
					<form:textarea path="productComposition" rows="3" />
	    		</p>
            </div>
		  </div>
		  <hr>
		  <div class="row-lg-10">
            <div class="form-group">
            	<p>
			        <form:label path="item.account.email">이메일</form:label>:<br>
					<form:input path="item.account.email" rows="3" />
			    </p>
            </div>
		  </div>
		  <div class="row-lg-10">
            <div class="form-group">
            	<p>
			        <form:label path="item.account.accountNum">입금 계좌</form:label>:<br>
					<form:input path="item.account.accountNum" />
			    </p>
            </div>
		  </div>
		  <br>
		  <div class="row-lg-10">
		  	<div class="form-group">-->
		  		<input type="submit" class="btn btn-primary btn-lg" value="저장 하기">
            </div>
		  </div>
		</form:form> 
	</div>						
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
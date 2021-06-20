<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function checkDisable(frm)
{
    if( frm.immdPurchase.checked == true ){
	   frm.immdPurchasePrice.disabled = true;
	} else 
	{
	   frm.immdPurchasePrice.disabled = false;
	}
}
</script>
</head>
<body>
<br><h1 align="center">중고물품 등록하기</h1><br>
<div class="container">
	<form:form action="/personalDeal/add" modelAttribute="personalDealItem" method="post" enctype="multipart/form-data">
		<label>상위 카테고리</label>:
		<select class="category1" id="category1" name="category1">
			<option value="">전체</option>
		</select>
		&nbsp; 
		<label>하위 카테고리</label>:
		<select class="category2" id="category2" name="category2">
			<option value="">전체</option>
		</select>
		
		<br>
		<form:label path="item.title">물품 제목</form:label>:<br>
		<form:input path="item.title" />
		<br>
		<form:label path="item.description">물품 설명</form:label>:<br>
		<form:textarea path="item.description" rows="20" cols="170"/>
		<br>
		<form:label path="item.img">이미지</form:label>:<br>
		<input type="file" id="file" name="file" placeholder="파일 선택">
		<br>
		<form:label path="item.quantity">수량</form:label>:<br>
		<form:input path="item.quantity" />
		<hr>
		<form:label path="location">희망 거래지역</form:label>:<br>
		<form:input path="location" />
		<br>
		<form:label path="price">희망 판매가</form:label>:<br>
		<form:input path="price" />
		<br>
		<form:label path="item.regiDate">물품 등록일</form:label>:<br>
		<input type="datetime-local" id="regiDate" name="regiDate" value="${item.regiDate}"/>
		<br>
		<form:label path="item.shippingFee">배송비</form:label>:<br>
		<form:input path="item.shippingFee" />
		<hr>
		<input type="submit" class="btn btn-primary btn-lg" value="등록하기">
	</form:form>
</div>
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
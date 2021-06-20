<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<title>내 정보</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</head>
<body>
<table>
	<tr>
		<td><jsp:include page="header.jsp" flush="false"/></td>
	</tr>
	<tr>
		<td>
			<h2>내 정보</h2>
			<form:form modelAttribute="account">
				<form:label path="userid"/>아이디:
				${account.userid}
				<br>
				<form:label path="pwd"/>비밀번호:
				<form:password path="pwd"/>
				<form:errors path="pwd"/>
				<br>
				<form:label path="pwdconfirm"/>비밀번호 확인:
				<form:password path="pwdconfirm"/>
				<form:errors path="pwdconfirm"/>
				<br>
				<form:label path="name"/>이름:
				${account.name}
				<br>
				<form:label path="email"/>이메일:
				<input type="text" name="email" id="email" value="<c:out value="${account.email}"/>"/>
				<form:errors path="email"/>
				<br>
				<form:label path="phone"/>전화번호:
				<input type="text" name="phone" id="phone" value="<c:out value="${account.phone}"/>"/>
				<form:errors path="phone3"/>
				<br>
				<form:label path="addr"/>주소:
				<form:input path="addr"/>
				<form:errors path="addr"/>
				<br>
				<label>관심 카테고리</label>:
				<select class="category1" id="category1" name="category1">
					<option value="<c:out value="${account.favcategory}"/>">${account.favcategory}</option>
				</select>
				<br>
				<input type="submit" class="btn btn-primary btn-lg" value="내 정보 수정">
			</form:form>
		</td>
	</tr>
	<tr>
		<td>
			<jsp:include page="footer.jsp" flush="false"/>
		</td>
	</tr>
</table>
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
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
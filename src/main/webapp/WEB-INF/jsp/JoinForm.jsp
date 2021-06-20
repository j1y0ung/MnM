<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<title>JoinForm</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</head>
<body>
<div align="center">
<jsp:include page="header.jsp" flush="false"/>
<table>
	<tr>
		<td>
			<h2>회원가입</h2>
			<form:form modelAttribute="account">
				<form:label path="userid"/>아이디
				<form:input path="userid"/>
				<form:errors path="userid"/>
				<br>
				<form:label path="pwd"/>비밀번호
				<form:password path="pwd"/>
				<form:errors path="pwd"/>
				<br>
				<form:label path="pwdconfirm"/>비밀번호 확인
				<form:password path="pwdconfirm"/>
				<form:errors path="pwdconfirm"/>
				<br>
				<form:label path="name"/>이름
				<form:input path="name"/>
				<form:errors path="name"/>
				<br>
				<form:label path="email"/>이메일
				<form:input path="email"/>@
				<form:select path="emailDomain">
					<form:option value="@naver.com" label="naver.com"/>
					<form:option value="@gmail.com" label="gmail.com"/>
					<form:option value="@dongduk.ac.kr" label="dongduk.ac.kr"/>
				</form:select>
				<form:errors path="email"/>
				<br>
				<form:label path="phone"/>전화번호
				<form:select path="phone">
					<form:option value="010" label="010"/>
					<form:option value="011" label="011"/>
					<form:option value="012" label="012"/>
				</form:select>-
				<form:input path="phone2"/>
				-
				<form:input path="phone3"/>
				<form:errors path="phone3"/>
				<br>
				<form:label path="addr"/>주소
				<form:input path="addr"/>
				<form:errors path="addr"/>
				<br>
				<label>관심 카테고리</label>:
				<select class="category1" id="category1" name="category1">
					<option value="">---</option>
				</select>
				<br>
				<input type="submit" class="btn btn-primary btn-lg" value="가입하기">
			</form:form>
		</td>
	</tr>
</table>
<jsp:include page="footer.jsp" flush="false"/>
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
	cate1Select.append("<option value='" + cate1Arr[i].catName + "'>"
      + cate1Arr[i].catName + "</option>"); 
}
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<div align="center">
	<jsp:include page="header.jsp" flush="false"/>
	<div>
		<a href="/myaccount">내 정보 보기</a>
	</div>
	<div>
		<a href="/personalDeal/myList">중고물품 판매내역</a><br>
		<a href="#">구매내역</a><br>
		<a href="/crowdFunding/myList">나의 크라우드펀딩</a><br>
		<a href="/auction/history">경매내역</a><br>
	</div>
	<div>
		<table>
			<tr>
				<td colspan="2">
					<h2>favorite category와 관련된 추천</h2>
				</td>
			<tr>
				<td>
					<p>중고거래</p>
				</td>
				<td><a href="/personalDeal/add">판매 물건 등록하기</a></td>
			</tr>
			<tr>
				<td>
					<p>경매</p>
				</td>
				<td><a href="/auction/add">판매 물건 등록하기</a>
				</td>
			<tr>
				<td>
					<p>크라우드펀딩</p>
				</td>
				<td><a href="/crowdFunding/add">판매 물건 등록하기</a>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp" flush="false"/>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>경매 물품 정보</title>
</head>
<body>
<table id="auctionItem">
	<tr>
		<td rowspan="7">${auctionItem.img}</td>
		<td>${auctionItem.title}</td>
	</tr>
	<tr>
		<td>현재 입찰가: ${auctionItem.currentPrice}원</td>
	</tr>
	<tr>
		<td>물품 번호: ${auctionItem.auctionId}</td>
	</tr>
	<tr>
		<td>경매 기간: ${auctionItem.startDate}</td>
	</tr>
	<tr>
		<td>시작가: ${auctionItem.startPrice}원</td>
	</tr>
	<tr>
		<td>입찰단위: ${auctionItem.bidUnit}원</td>
	</tr>
	<tr>
		<td>즉시구매가: ${auctionItem.immdPurchasePrice}원</td>
	</tr>
	<tr>
		<td>최고 입찰자: ${auctionItem.bidInfo}</td>
	</tr>
	<tr>
		<td>입찰 수: ${auctionItem.bidNum}</td>
	</tr>
	<tr>
		<td>판매자 ID: ${auctionItem.bidInfo}</td>
	</tr>
	<tr>
		<td>물품 정보: ${auctionItem.bidInfo}</td>
	</tr>
	<tr>
		<td>
			<a href='<c:url value="/auction/bidding.do">
            <c:param name="itemId" value="${item.itemId}"/></c:url>'>입찰하기</a>
        </td>
		<td>
	        <a href='<c:url value="/shop/addItemToCart.do">
	          <c:param name="itemId" value="${item.itemId}"/></c:url>'>장바구니 넣기</a>
      	</td>
		<td>
			<a href='<c:url value="/auction/biddingProgress.do">
	          <c:param name="itemId" value="${item.itemId}"/></c:url>'>경매현황 보기</a>
      	</td>
	</tr>
</table>
</body>
</html>
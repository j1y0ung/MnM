<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��� ��ǰ ����</title>
</head>
<body>
<table id="auctionItem">
	<tr>
		<td rowspan="7">${auctionItem.img}</td>
		<td>${auctionItem.title}</td>
	</tr>
	<tr>
		<td>���� ������: ${auctionItem.currentPrice}��</td>
	</tr>
	<tr>
		<td>��ǰ ��ȣ: ${auctionItem.auctionId}</td>
	</tr>
	<tr>
		<td>��� �Ⱓ: ${auctionItem.startDate}</td>
	</tr>
	<tr>
		<td>���۰�: ${auctionItem.startPrice}��</td>
	</tr>
	<tr>
		<td>��������: ${auctionItem.bidUnit}��</td>
	</tr>
	<tr>
		<td>��ñ��Ű�: ${auctionItem.immdPurchasePrice}��</td>
	</tr>
	<tr>
		<td>�ְ� ������: ${auctionItem.bidInfo}</td>
	</tr>
	<tr>
		<td>���� ��: ${auctionItem.bidNum}</td>
	</tr>
	<tr>
		<td>�Ǹ��� ID: ${auctionItem.bidInfo}</td>
	</tr>
	<tr>
		<td>��ǰ ����: ${auctionItem.bidInfo}</td>
	</tr>
	<tr>
		<td>
			<a href='<c:url value="/auction/bidding.do">
            <c:param name="itemId" value="${item.itemId}"/></c:url>'>�����ϱ�</a>
        </td>
		<td>
	        <a href='<c:url value="/shop/addItemToCart.do">
	          <c:param name="itemId" value="${item.itemId}"/></c:url>'>��ٱ��� �ֱ�</a>
      	</td>
		<td>
			<a href='<c:url value="/auction/biddingProgress.do">
	          <c:param name="itemId" value="${item.itemId}"/></c:url>'>�����Ȳ ����</a>
      	</td>
	</tr>
</table>
</body>
</html>
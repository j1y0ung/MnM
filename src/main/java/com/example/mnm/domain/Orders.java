package com.example.mnm.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@SuppressWarnings("serial")
public class Orders implements Serializable{
	private int orderId;
	private Date orderDate; // 주문일자
	@NotEmpty
	private String shipAddr; // 배송받을 주소
	private int totalPrice; // 총 가격
	@NotEmpty
	private String shipToName; // 이름
	@NotEmpty
	private String bankName; // 은행명
	@NotEmpty
	private String cardNumber; // 카드 번호
	@NotEmpty
	private String expiryDate; // 카드 만료일
	@NotEmpty
	private String phone; // 전화번호
	private String userId; // 주문인 아이디
	private List<LineItem> lineItems = new ArrayList<LineItem>();
	private LineItem cLineItem;

	public Orders() {
		cLineItem = new LineItem();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getShipAddr() {
		return shipAddr;
	}
	public void setShipAddr(String shipAddr) {
		this.shipAddr = shipAddr;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getShipToName() {
		return shipToName;
	}
	public void setShipToName(String shipToName) {
		this.shipToName = shipToName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	public void addAuctionLineItem(AuctionItem auctionItem) {
		LineItem lineItem = new LineItem(lineItems.size() + 1, auctionItem);
		addLineItem(lineItem);
	}
	public void addLineItem(LineItem lineItem) {
		lineItems.add(lineItem);
	}
	
	public LineItem getcLineItem() {
		return cLineItem;
	}
	public void setcLineItem(LineItem cLineItem) {
		this.cLineItem = cLineItem;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", shipAddr=" + shipAddr + ", totalPrice="
				+ totalPrice + ", shipToName=" + shipToName + ", bankName=" + bankName + ", cardNumber=" + cardNumber
				+ ", expiryDate=" + expiryDate + ", phone=" + phone + ", userId=" + userId + ", lineItems=" + lineItems
				+ ", lineItem=" + cLineItem + "]";
	}

	
	
}
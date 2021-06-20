package com.example.mnm.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

@SuppressWarnings("serial")
public class Orders implements Serializable{
	private int orderId;
	private Date orderDate;
	@NotEmpty
	private String shipAddr;
	private int totalPrice;
	@NotEmpty
	private String shipToName;
	@NotEmpty
	private String bankName;
	@NotEmpty
	private String cardNumber;
	@NotEmpty
	private String expiryDate;
	@NotEmpty
	private String phone;
	private String userId;
  
	private int lineNum;

	private List<LineItem> lineItems = new ArrayList<LineItem>();

	public Orders() {
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

	public int getLineNum() {
		return lineNum;
	}
	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;

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
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", shipAddr=" + shipAddr + ", totalPrice="
				+ totalPrice + ", shipToName=" + shipToName + ", bankName=" + bankName + ", cardNumber=" + cardNumber
				+ ", expiryDate=" + expiryDate + ", phone=" + phone + ", userId=" + userId + "]";

	}
	
	
}
package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LineItem implements Serializable {

  /* Private Fields */

  private int orderId;
  private int lineNumber;
  private int quantity;
  private String itemId;
  private double unitPrice;
  private Item item;

  /* Constructors */

  public LineItem() {}

//  public LineItem(int lineNumber, CartItem cartItem) {
//    this.lineNumber = lineNumber;
//    this.quantity = cartItem.getQuantity();
//    this.itemId = cartItem.getItem().getItemId();
//    this.unitPrice = cartItem.getItem().getListPrice();
//    this.item = cartItem.getItem();
//  }
  
  public LineItem(int lineNumber, AuctionItem auctionItem) {
	    this.lineNumber = lineNumber;
	    this.quantity = auctionItem.getItem().getQuantity();
	    this.itemId = auctionItem.getItem().getItemId();
	    this.unitPrice = auctionItem.getWinningBidPrice();
	    this.item = auctionItem.getItem();
  }

  /* JavaBeans Properties */

  public int getOrderId() { return orderId; }
  public void setOrderId(int orderId) { this.orderId = orderId; }

  public int getLineNumber() { return lineNumber; }
  public void setLineNumber(int lineNumber) { this.lineNumber = lineNumber; }

  public String getItemId() { return itemId; }
  public void setItemId(String itemId) { this.itemId = itemId; }

  public double getUnitPrice() { return unitPrice; }
  public void setUnitPrice(double unitprice) { this.unitPrice = unitprice; }

  public Item getItem() { return item; }
  public void setItem(Item item) {
    this.item = item;
  }

  public int getQuantity() { return quantity; }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getTotalPrice() {
	return this.unitPrice * this.quantity;
  }

@Override
public String toString() {
	return "LineItem [orderId=" + orderId + ", lineNumber=" + lineNumber + ", quantity=" + quantity + ", itemId="
			+ itemId + ", unitPrice=" + unitPrice + ", item=" + item + "]";
}
  
}

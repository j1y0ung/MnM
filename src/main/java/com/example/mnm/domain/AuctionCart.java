package com.example.mnm.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.support.PagedListHolder;

@SuppressWarnings("serial")
public class AuctionCart implements Serializable {

	  /* Private Fields */

	  private final Map<String, AuctionItem> itemMap = Collections.synchronizedMap(new HashMap<String, AuctionItem>());
	  private final PagedListHolder<AuctionItem> itemList = new PagedListHolder<AuctionItem>();

	  /* JavaBeans Properties */

	  public AuctionCart() {
		  this.itemList.setPageSize(4);
	  }

	  public PagedListHolder<AuctionItem> getCartItemList() { return itemList; }
	  public int getNumberOfItems() { return itemList.getSource().size(); }

	  /* Public Methods */

	  public boolean containsItemId(String itemId) {
	    return itemMap.containsKey(itemId);
	  }

	  public void addItem(AuctionItem auctionItem) {
	      itemMap.put(auctionItem.getAuctionId(), auctionItem);
	      itemList.getSource().add(auctionItem);
	  }

	  public AuctionItem removeItemById(String itemId) {
	    AuctionItem auctionItem = itemMap.remove(itemId);
	    if (auctionItem == null) {
	      return null;
	    }
	    else {
	      itemList.getSource().remove(auctionItem);
	      return auctionItem;
	    }
	  }

	}
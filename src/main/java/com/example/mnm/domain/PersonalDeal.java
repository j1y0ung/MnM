package com.example.mnm.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.support.PagedListHolder;

public class PersonalDeal implements Serializable {
	private Map<String, PersonalDealItem> dealList = Collections.synchronizedMap(new HashMap<String, PersonalDealItem>()); //개인간 거래 리스트
	private final PagedListHolder<PersonalDealItem> itemList = new PagedListHolder<PersonalDealItem>();
	
	public PersonalDeal() {
		this.itemList.setPageSize(4);
	}
	
	//모든 거래 물품 반환
	public Iterator<PersonalDealItem> getAllPersonalDealItems() { return itemList.getSource().iterator(); }
	
	//거래 물품 리스트 반환
	public PagedListHolder<PersonalDealItem> getPersonalDealItemList() { return itemList; }
	
	//거래 물품 추가
//	public void addPersonalDealItem(PersonalDealItem item) {
//		PersonalDealItem personalDealItem = dealList.get(item.getItem());
//    if (personalDealItem == null) {
//    	personalDealItem = new PersonalDealItem();
//    	personalDealItem.setItem(item.getItem());
//    	personalDealItem.setTitle("");
//    	personalDealItem.setShippingFee("");
//    	personalDealItem.setDescription("");
////    	personalDealItem.setDate(date);
//    	personalDealItem.setLocation("");
//    	personalDealItem.setDealStatus("");
//    	personalDealItem.setViews(0);
//        dealList.put(item.getItem().getItemId(), personalDealItem);
//        dealList.getSource().add(personalDealItem);
//      }
//      cartItem.incrementQuantity();
//    }
//	
//	//거래 물품 삭제
//	+ removePersonalDealItemById()
//	
//	//거래 물품 정보 업데이트
//	+ updatePersonalDealItemById()
//	
//	//거래 상태 마감으로 변경
//	+ finishDealById() 


}

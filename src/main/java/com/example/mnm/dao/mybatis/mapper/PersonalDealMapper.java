package com.example.mnm.dao.mybatis.mapper;

import java.util.List;
import java.util.Date;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.domain.PersonalDealItemList;
import com.example.mnm.domain.DealForm;
import com.example.mnm.domain.Item;

@Repository
@Mapper
public interface PersonalDealMapper {
	
	List<PersonalDealItem> getPersonalDealItemList(); //거래 물품 리스트 반환	
	List<PersonalDealItemList> searchPersonalDealItemList(String word);
	List<PersonalDealItemList> getNewestPersonalDealItemList();
	List<PersonalDealItemList> getPopularPersonalDealItemList();
	List<PersonalDealItemList> getLowestPricePersonalDealItemList();
	List<PersonalDealItemList> getHightestPricePersonalDealItemList();
	List<PersonalDealItemList> getFourPersonalDealItemList();
	List<PersonalDealItem> getPersonalDealItemListById(String userId);
	List<PersonalDealItem> getRecommendedItemList(String fav);
	
	PersonalDealItem getPersonalDealItemById(String personalDealId);
	PersonalDealItem getPersonalDealItem(String personalDealId);
	void addPersonalDealItem(PersonalDealItem personalDealItem); //거래 물품 추가
	void addItem(Item item);
	void removePersonalDealItem(PersonalDealItem personalDealItem);
	void removeItemById(String itemId);
	void removePersonalDealItem(String personalDealId);
	void updatePersonalDealItem(PersonalDealItem personalDealItem);
	void finishDealById(int userId, PersonalDealItem personalDealItem); //거래 상태 마감으로 변경
	void purchase(DealForm dealForm);
	//void purchase2(DealForm dealForm);
	void updatePurchase(String status, String personalDealId);
	List<PersonalDealItem> getPurchasedPersonalDealItemListById(String userid);

}

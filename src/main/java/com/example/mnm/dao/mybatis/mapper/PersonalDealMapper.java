package com.example.mnm.dao.mybatis.mapper;

import java.util.List;
import java.util.Date;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.domain.Item;

@Repository
@Mapper
public interface PersonalDealMapper {
	
	List<PersonalDealItem> getAllPersonalDealItems(); //모든 거래 물품 반환	
	List<PersonalDealItem> getPersonalDealItemList(); //거래 물품 리스트 반환	
	PersonalDealItem getPersonalDealItemById(String personalDealId);
	void addPersonalDealItem(PersonalDealItem personalDealItem); //거래 물품 추가
	void addItem(Item item);
	void removePersonalDealItemById(String itemId); //거래 물품 삭제
	void removePersonalDealItem(PersonalDealItem personalDealItem);
	void removeItemById(String itemId);
	void updatePersonalDealItemById(String personalDealId, PersonalDealItem personalDealItem); //거래 물품 정보 업데이트
	void updateItemById(String itemId, Item item);
	void finishDealById(int userId, PersonalDealItem personalDealItem); //거래 상태 마감으로 변경
	List<PersonalDealItem> searchPersonalDealItemList(String word);
	List<PersonalDealItem> getNewestPersonalDealItemList();
	List<PersonalDealItem> getPopularPersonalDealItemList();
	List<PersonalDealItem> getLowestPricePersonalDealItemList();
	List<PersonalDealItem> getHightestPricePersonalDealItemList();
	List<PersonalDealItem> getFourPersonalDealItemList();
	PersonalDealItem getPersonalDealItem(String personalDealId);
	void removePersonalDealItem(String personalDealId);
	List<PersonalDealItem> getRecommendedItemList(String fav);
}

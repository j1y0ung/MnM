package com.example.mnm.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.FundingForm;
import com.example.mnm.domain.Item;

@Repository
@Mapper
public interface CrowdFundingMapper {

	List<CrowdFundingItem> getAllFundingItems(); // 모든 펀딩 반환
	CrowdFundingItem getFundingItemById(String crowdFundingId); // 펀딩 반환
	List<CrowdFundingItem> getMyFundingItemListById(String userId); // 내가 등록한 펀딩 반환 
	List<CrowdFundingItem> getMyFundingItemsCheckoutById(String userId); //내가 펀딩한 펀딩 반환 
	void addFundingItem(CrowdFundingItem crowdFundingItem); // 펀딩 추가
	void addItem(Item item);
	void removeFundingItemById(String itemId); // 펀딩 삭제
	void removeItemById(String itemId); // 펀딩 삭제
	void updateFundingItemById(String crowdFundingId, CrowdFundingItem crowdFundingItem); // 펀딩 내용 수정
	void updateItemById(String itemId, Item item);
	// 펀딩하기 
	void fund(FundingForm fundingForm); // orders에 삽입 
	void fund2(FundingForm fundingForm); // LineItem에 삽입 
	void fundUpdate(FundingForm fundingForm); // crowdFunding 업데이트 
}

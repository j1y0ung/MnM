package com.example.mnm.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.FundingForm;
import com.example.mnm.domain.Item;

@Repository
@Mapper
public interface CrowdFundingMapper {

	List<CrowdFundingItem> getCrowdFundingItemList(); // 모든 펀딩 반환
	List<CrowdFundingItem> getCrowdFundingItemListRecently(); // 최신순 
	List<CrowdFundingItem> getCrowdFundingItemListMostViews(); // 인기순 
	List<CrowdFundingItem> getCrowdFundingItemListMostSponsors(); // 후원자 최다 순  
	List<CrowdFundingItem> getCrowdFundingItemListMostAmount(); // 후원금액 최다 순 
	List<CrowdFundingItem> getCrowdFundingItemListDeadLine(); // 마감일 순 
	List<CrowdFundingItem> getCrowdFundingItemListCategory(Category categoryCommand); 
	
	CrowdFundingItem getFundingItemById(String crowdFundingId); // 펀딩 반환
	List<CrowdFundingItem> getMyFundingItemListById(String userId); // 내가 등록한 펀딩 반환 
	List<FundingForm> getMyFundingItemsCheckoutById(String userId); //내가 펀딩한 펀딩 반환 
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
	// 펀딩 취소
	void cancelMyFundingItemsCheckout(FundingForm fundingForm);
	void cancel2(FundingForm fundingForm);
	void cancelUpdate(FundingForm fundingForm);
	
	List<CrowdFundingItem> getFourCrowdFundingItemList(); // 홈에 노출될 아이템 4개 반환
	
}

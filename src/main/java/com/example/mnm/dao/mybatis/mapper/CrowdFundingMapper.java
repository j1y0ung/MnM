package com.example.mnm.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.Item;

@Repository
@Mapper
public interface CrowdFundingMapper {

	List<CrowdFundingItem> getAllFundingItems(); // 모든 펀딩 반환
	CrowdFundingItem getFundingItemById(String crowdFundingId); // 펀딩 반환
	void addFundingItem(CrowdFundingItem crowdFundingItem); // 펀딩 추가
	void addItem(Item item);
	void removeFundingItemById(String itemId); // 펀딩 삭제
	void removeItemById(String itemId); // 펀딩 삭제
	void updateFundingItemById(String crowdFundingId, CrowdFundingItem crowdFundingItem); // 펀딩 내용 수정
	void updateItemById(String itemId, Item item);
	void fund(String crowdFundingId); // 후원하기
	List<CrowdFundingItem> getMyFundingItemListByUserId(String userId);
}

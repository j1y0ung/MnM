package com.example.mnm.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.mnm.domain.CrowdFundingItem;

@Repository
@Mapper
public interface CrowdFundingMapper {

	List<CrowdFundingItem> getAllFundingItems(); // 모든 펀딩 반환
	List<CrowdFundingItem> getfundingItemList(); // 펀딩 리스트 반환
	void addFundingItem(CrowdFundingItem crowdFundingItem); // 펀딩 추가
	void removeFundingItemById(int id); // 펀딩 삭제
	void updateFundingItemById(int id, CrowdFundingItem crowdFundingItem); // 펀딩 내용 수정
	void fund(int id); // 후원하기
}

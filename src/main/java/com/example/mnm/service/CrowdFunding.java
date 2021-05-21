package com.example.mnm.service;

import org.springframework.beans.support.PagedListHolder;

import com.example.mnm.domain.CrowdFundingItem;

public interface CrowdFunding {

	public PagedListHolder<CrowdFundingItem> getAllFundingItems(); // 모든 펀딩 반환
	public PagedListHolder<CrowdFundingItem> getfundingItemList(); // 펀딩 리스트 반환
	public void addFundingItem(CrowdFundingItem crowdFundingItem); // 펀딩 추가
	public void removeFundingItemById(int id); // 펀딩 삭제
	public void updateFundingItemById(int id, CrowdFundingItem crowdFundingItem); // 펀딩 내용 수정
	public void fund(int id); // 후원하기

}

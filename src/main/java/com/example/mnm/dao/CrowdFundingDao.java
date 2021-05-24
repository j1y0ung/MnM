package com.example.mnm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.Item;

public interface CrowdFundingDao {

	public List<CrowdFundingItem> getAllFundingItems() throws DataAccessException; // 모든 펀딩 반환
	public CrowdFundingItem getFundingItemById(String crowdFundingId) throws DataAccessException; // 펀딩 리스트 반환
	public void addFundingItem(CrowdFundingItem crowdFundingItem) throws DataAccessException; // 펀딩 추가
	public void addItem(Item item) throws DataAccessException;
	public void removeFundingItemById(String crowdFundingId) throws DataAccessException; // 펀딩 삭제
	public void updateFundingItemById(String crowdFundingId, CrowdFundingItem crowdFundingItem) throws DataAccessException; // 펀딩 내용 수정
	public void fund(String crowdFundingId) throws DataAccessException; // 후원하기

}

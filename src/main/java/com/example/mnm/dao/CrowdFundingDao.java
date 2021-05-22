package com.example.mnm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.CrowdFundingItem;

public interface CrowdFundingDao {

	public List<CrowdFundingItem> getAllFundingItems() throws DataAccessException; // 모든 펀딩 반환
	public CrowdFundingItem getFundingItemById(String crowdFundingId) throws DataAccessException; // 펀딩 리스트 반환
	public void addFundingItem(CrowdFundingItem crowdFundingItem) throws DataAccessException; // 펀딩 추가
	public void removeFundingItemById(int id) throws DataAccessException; // 펀딩 삭제
	public void updateFundingItemById(int id, CrowdFundingItem crowdFundingItem) throws DataAccessException; // 펀딩 내용 수정
	public void fund(int id) throws DataAccessException; // 후원하기

}

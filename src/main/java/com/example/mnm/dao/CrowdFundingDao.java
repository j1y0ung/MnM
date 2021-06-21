package com.example.mnm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.FundingForm;
import com.example.mnm.domain.Item;

public interface CrowdFundingDao {

	public List<CrowdFundingItem> getCrowdFundingItemList() throws DataAccessException; // 모든 펀딩 반환
	public List<CrowdFundingItem> getCrowdFundingItemListRecently() throws DataAccessException;
	public List<CrowdFundingItem> getCrowdFundingItemMostViews() throws DataAccessException;
	public List<CrowdFundingItem> getCrowdFundingItemListMostSponsors() throws DataAccessException;
	public List<CrowdFundingItem> getCrowdFundingItemListMostAmount() throws DataAccessException;
	public List<CrowdFundingItem> getCrowdFundingItemListDeadLine() throws DataAccessException;
	public List<CrowdFundingItem> getCrowdFundingItemListCategory(Category category) throws DataAccessException;
	
	public CrowdFundingItem getFundingItemById(String crowdFundingId) throws DataAccessException; // 펀딩 반환
	public List<CrowdFundingItem> getMyFundingItemListById(String userId); // 내가 등록한 펀딩 반환 
	public List<FundingForm> getMyFundingItemsCheckoutById(String userId) throws DataAccessException; // 내 펀딩 내역 반환 
	public void addFundingItem(CrowdFundingItem crowdFundingItem) throws DataAccessException; // 펀딩추가
	public void addItem(Item item) throws DataAccessException;
	public void removeFundingItemById(String crowdFundingId) throws DataAccessException; // 펀딩 삭제
	public void removeItemById(String itemId) throws DataAccessException;
	public void updateFundingItemById(String crowdFundingId, CrowdFundingItem crowdFundingItem) throws DataAccessException; // 펀딩 내용 수정
	public void updateItemById(String itemId, Item item) throws DataAccessException;
	public void fund(FundingForm fundingForm) throws DataAccessException;// 후원하기
	public void fund2(FundingForm fundingForm) throws DataAccessException;
	public void fundUpdate(FundingForm fundingForm) throws DataAccessException;
	List<CrowdFundingItem> getFourCrowdFundingItemList() throws DataAccessException;
	public void cancelMyFundingItemsCheckout(FundingForm fundingForm) throws DataAccessException;
	public void cancel2(FundingForm fundingForm) throws DataAccessException;
	public void cancelUpdate(FundingForm fundingForm) throws DataAccessException;
	public void fundConclude(String crowdFundingId) throws DataAccessException;
	
	

}

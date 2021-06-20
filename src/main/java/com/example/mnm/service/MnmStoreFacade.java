package com.example.mnm.service;

import java.util.Date;
import java.util.List;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.AuctionItemList;
import com.example.mnm.domain.Bid;
import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.FundingForm;
import com.example.mnm.domain.Item;
import com.example.mnm.domain.LineItem;
import com.example.mnm.domain.Orders;
import com.example.mnm.domain.PersonalDealItem;

public interface MnmStoreFacade {
	// item
	Item getItem(String itemId);
	void insertItem(Item item);
	void updateItem(Item item);
	void deleteItem(String itemId);
	int getViews(String itemId);
	Date getRegiDate(String itemId);
	void increaseItemViews(String itemId);
	
	// category
	Category getCategory(String categoryId);
	List<Category> getCategoryList();
	String getCategoryName(String categoryId);
	
	// 홈에 노출되는 아이템
	List<PersonalDealItem> getFourPersonalDealItemList();
	List<AuctionItemList> getFourAuctionItemList();
	List<CrowdFundingItem> getFourCrowdFundingItemList();
	
	// 회원 관리
	void insertAccount(Account account);
	void deleteAccount(String userid);
	void updateAccount(Account account);
	List<Account> getAccountList(); 
	String getPwd(String userid);
	Account getAccount(String userid);
	String hasAccount(String userid);
  
	//Auction
	void insertAuctionItem(AuctionItem auctionItem);
	List<AuctionItemList> getRecentAuctionItemList();
	List<AuctionItemList> getPopularAuctionItemList();
	List<AuctionItemList> getMostBiddingAuctionItemList();
	List<AuctionItemList> getClosingAuctionItemList();
	List<AuctionItemList> searchAuctionItemList(String word);
	AuctionItem getAuctionItem(String auctionId);
	void updateAuctionItem(AuctionItem auctionItem);
	void deleteAuctionItem(String auctionId);
	void insertBidding(Bid bid);
	void updateCurrentPrice(String auctionId, int bidPrice);
	List<Bid> getBids(String auctionId);
	void startAuctionScheduler(Date startTime, String auctionId);
	void endAuctionScheduler(Date endTime, String auctionId);
	String getStatus(String auctionId);
	void updateImmediatePurchase(String auctionId, int immdPurchasePrice, String winnerId);
	void updateGiveUpWinning(String auctionId, String userId);
	Bid findSecondBid(String auctionId, String preWinnerId);
	Bid findWinnerBid(String auctionId);
	void updateWinner(String winnerId, int bidPrice, String auctionId, Date curTime);
	void insertOrders(Orders orders);
	void insertLineItem(List<LineItem> lineItems);
	void updateStatus(String status, String auctionId);
	Orders getAuctionOrder(int orderId);
	int getOrderId(int itemId);
	void updateRebidding(String auctionId);
	List<AuctionItemList> getSellingAuctionItemList(String userId);
	List<AuctionItemList> getBiddingAuctionItemList(String userId);
	List<AuctionItemList> getAuctionedItemList(String userId);
	
	// CrowdFunding	
	List<CrowdFundingItem> getCrowdFundingItemList();
	List<CrowdFundingItem> getCrowdFundingItemListRecently();
	List<CrowdFundingItem> getCrowdFundingItemListMostViews();
	List<CrowdFundingItem> getCrowdFundingItemListMostSponsors();
	List<CrowdFundingItem> getCrowdFundingItemListMostAmount();
	List<CrowdFundingItem> getCrowdFundingItemListDeadLine();
	List<CrowdFundingItem> getCrowdFundingItemListCategory(Category category);
	
	CrowdFundingItem getFundingItemById(String crowdFundingId);
	List<CrowdFundingItem> getMyFundingItemListById(String userId);
	List<FundingForm> getMyFundingItemsCheckoutById(String userId);
	void addFundingItem(CrowdFundingItem crowdFundingItem); 
	void removeFundingItemById(String itemId);
	void updateFundingItemById(String crowdFundingId, CrowdFundingItem crowdFundingItem); 
	void fund(FundingForm fundingForm);
	void cancelMyFundingItemsCheckout(FundingForm fundingForm);
	
	//PersonalDeal
	List<PersonalDealItem> getAllPersonalDealItems();
	List<PersonalDealItem> getPersonalDealItemList();
	PersonalDealItem getPersonalDealItemById(String personalDealId);
	PersonalDealItem getPersonalDealItem(String personalDealId);
	void addPersonalDealItem(PersonalDealItem personalDealItem);
	void removePersonalDealItem(String personalDealId);
	void removePersonalDealItemById(String itemId);
	void updatePersonalDealItemById(String personalDealId, PersonalDealItem personalDealItem);
	void finishDealById(int userId, PersonalDealItem personalDealItem);
	List<PersonalDealItem> searchPersonalDealItemList(String word);
	List<PersonalDealItem> getNewestPersonalDealItemList();
	List<PersonalDealItem> getPopularPersonalDealItemList();
	List<PersonalDealItem> getLowestPricePersonalDealItemList();
	List<PersonalDealItem> getHightestPricePersonalDealItemList();
	
	
}
package com.example.mnm.service;

import java.util.Date;
import java.util.List;


import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.AuctionItemList;
import com.example.mnm.domain.Bid;
import com.example.mnm.domain.Item;

public interface MnmStoreFacade {

	// 회원 관리
	void insertAccount(Account account);
	void deleteAccount(String userid);
	void updateAccount(Account account);
	List<Account> getAccountList(); 
	String getPwd(String userid);
	Account getAccount(String userid);
	
	//Auction
	void insertAuctionItem(AuctionItem auctionItem);
	void insertItem(Item item);
	List<AuctionItemList> getRecentAuctionItemList();
	List<AuctionItemList> getPopularAuctionItemList();
	List<AuctionItemList> getMostBiddingAuctionItemList();
	List<AuctionItemList> getClosingAuctionItemList();
	List<AuctionItemList> searchAuctionItemList(String word);
	AuctionItem getAuctionItem(String auctionId);
	void updateAuctionItem(AuctionItem auctionItem);
	void updateItem(Item item);
	void increaseItemViews(String itemId);
	int getViews(String itemId);
	Date getRegiDate(String itemId);
	void deleteAuctionItem(String auctionId);
	void deleteItem(String itemId);
	void insertBidding(Bid bid);
	void updateCurrentPrice(String auctionId, int bidPrice);
	List<Bid> getBids(String auctionId);
	void startAuctionScheduler(Date startTime, String auctionId);
	void endAuctionScheduler(Date endTime, String auctionId);
	String getStatus(String auctionId);
	void updateImmediatePurchase(String auctionId, int immdPurchasePrice, String winnerId);
}
package com.example.mnm.service;

import java.util.Date;
import java.util.List;


import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.AuctionItemList;
import com.example.mnm.domain.Bid;
import com.example.mnm.domain.Item;
public interface MnmStoreFacade {

	// 로그인시 비밀번호 비교하는 용도
	String getPwd(String id);
		
	// 로그인 성공시 Account 얻어오는 용도
	Account getAccount(String id);

	void insertAccount(Account account);

//	void updateAccount(Account account);
//
//	List<String> getUsernameList();

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
package com.example.mnm.dao;

import java.util.Date;
import java.util.List;
import org.springframework.dao.DataAccessException;
import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.AuctionItemList;
import com.example.mnm.domain.Bid;
import com.example.mnm.domain.Orders;
import com.example.mnm.domain.LineItem;

public interface AuctionDao {

	  void insertAuctionItem(AuctionItem auctionItem) throws DataAccessException;
	  List<AuctionItemList> getRecentAuctionItemList() throws DataAccessException;
	  void startAuctionItemStatus(Date startDate, String auctionId) throws DataAccessException;
	  void updateFailedAuctionStatus(Date endDate, String auctionId) throws DataAccessException;
	  List<AuctionItemList> getPopularAuctionItemList() throws DataAccessException;
	  List<AuctionItemList> getMostBiddingAuctionItemList() throws DataAccessException;
	  List<AuctionItemList> getClosingAuctionItemList() throws DataAccessException;
	  List<AuctionItemList> searchAuctionItemList(String word) throws DataAccessException;
	  AuctionItem getAuctionItem(String auctionId) throws DataAccessException;
	  void updateAuctionItem(AuctionItem auctionItem) throws DataAccessException;
	  void updateGiveUpAuctionItem(String auctionId) throws DataAccessException;
      void updateGiveUpBid(String auctionId, String userId) throws DataAccessException;
	  void deleteAuctionItem(String auctionId) throws DataAccessException;
	  void insertBidding(Bid bid) throws DataAccessException;
	  void updateCurrentPrice(String auctionId, int bidPrice) throws DataAccessException;
	  List<Bid> getBids(String auctionId) throws DataAccessException;
	  void updateWinner(String winnerId, int bidPrice, String auctionId, Date curTime) throws DataAccessException;
	  Bid findWinnerBid(String auctionId) throws DataAccessException;
	  String getStatus(String auctionId) throws DataAccessException;
	  void updateImmediatePurchase(String auctionId, int immdPurchasePrice, String winnerId) throws DataAccessException;
	  Bid findSecondBid(String auctionId, String preWinnerId) throws DataAccessException;
	  void insertOrders(Orders orders) throws DataAccessException;
	  void insertLineItem(List<LineItem> lineItems) throws DataAccessException;
	  void updateStatus(String status, String auctionId) throws DataAccessException;
	  Orders getAuctionOrder(int orderId) throws DataAccessException;
	  int getOrderId(int itemId) throws DataAccessException;
	  void updateRebidding(String auctionId) throws DataAccessException;
	  List<AuctionItemList> getSellingAuctionItemList(String userId) throws DataAccessException;
	  List<AuctionItemList> getBiddingAuctionItemList(String userId) throws DataAccessException;
	  List<AuctionItemList> getAuctionedItemList(String userId) throws DataAccessException;
	  List<AuctionItemList> getFourAuctionItemList() throws DataAccessException;
}

package com.example.mnm.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.AuctionItemList;
import com.example.mnm.domain.Bid;
import com.example.mnm.domain.Item;

@Mapper
public interface AuctionMapper {

	  void insertAuctionItem(AuctionItem auctionItem);
	  
	  AuctionItem getAuctionItem(String auctionId);

	  List<AuctionItemList> getRecentAuctionItemList();
	  
	  void startAuctionItemStatus(Date startDate, String auctionId);
	  
	  void endAuctionItemStatus(Date startDate, String auctionId);
	  
	  List<AuctionItemList> getPopularAuctionItemList();
	  
	  List<AuctionItemList> getMostBiddingAuctionItemList();
	  
	  List<AuctionItemList> getClosingAuctionItemList();
	  
	  List<AuctionItemList> searchAuctionItemList(String word);
	  
	  void updateAuctionItem(AuctionItem auctionItem);
	  
	  void deleteAuctionItem(String auctionId);
	  
	  void insertBidding(Bid bid);
	  
	  void updateCurrentPrice(String auctionId, int bidPrice);
	  
	  List<Bid> getBids(String auctionId);
	  
	  void updateWinner(String winnerId, int bidPrice, String auctionId);
	  
	  Bid findWinnerBid(String auctionId);
	  
	  String getStatus(String auctionId);
	  
	  void updateImmediatePurchase(String auctionId, int immdPurchasePrice, String winnerId);
  
  List<AuctionItemList> getFourAuctionItemList(); // 홈에 노출될 아이템 4개 반환
}

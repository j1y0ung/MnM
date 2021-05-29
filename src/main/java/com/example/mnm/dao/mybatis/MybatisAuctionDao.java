package com.example.mnm.dao.mybatis;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.dao.AuctionDao;
import com.example.mnm.dao.mybatis.mapper.AuctionMapper;
import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.AuctionItemList;
import com.example.mnm.domain.Bid;
import com.example.mnm.domain.Item;

@Repository
public class MybatisAuctionDao implements AuctionDao {

	@Autowired
	private AuctionMapper auctionMapper;

	public void insertAuctionItem(AuctionItem auctionItem) throws DataAccessException {
		auctionMapper.insertAuctionItem(auctionItem);
	}
	
	public AuctionItem getAuctionItem(String auctionId) throws DataAccessException {
		return auctionMapper.getAuctionItem(auctionId);
	}
	
	public List<AuctionItemList> getRecentAuctionItemList() throws DataAccessException {
		return auctionMapper.getRecentAuctionItemList();
	}
	
	public List<AuctionItemList> getPopularAuctionItemList() throws DataAccessException {
		return auctionMapper.getPopularAuctionItemList();
	}
	
	public List<AuctionItemList> getMostBiddingAuctionItemList() throws DataAccessException {
		return auctionMapper.getMostBiddingAuctionItemList();
	}
	
	public List<AuctionItemList> getClosingAuctionItemList() throws DataAccessException {
		return auctionMapper.getClosingAuctionItemList();
	}
	
	public List<AuctionItemList> searchAuctionItemList(String word) throws DataAccessException {
		return auctionMapper.searchAuctionItemList(word);
	}
	
	public void startAuctionItemStatus(Date startDate, String auctionId) throws DataAccessException {
		auctionMapper.startAuctionItemStatus(startDate, auctionId);
	}
	
	public void endAuctionItemStatus(Date endDate, String auctionId) throws DataAccessException {
		auctionMapper.endAuctionItemStatus(endDate, auctionId);
	}
	
	public void updateAuctionItem(AuctionItem auctionItem) throws DataAccessException {
		auctionMapper.updateAuctionItem(auctionItem);
	}
	
	public void deleteAuctionItem(String auctionId) throws DataAccessException {
		auctionMapper.deleteAuctionItem(auctionId);
	}
	
	public void insertBidding(Bid bid) throws DataAccessException {
		auctionMapper.insertBidding(bid);
	}
	
	public void updateCurrentPrice(String auctionId, int bidPrice) throws DataAccessException {
		auctionMapper.updateCurrentPrice(auctionId, bidPrice);
	}
	
	public List<Bid> getBids(String auctionId) throws DataAccessException {
		return auctionMapper.getBids(auctionId);
	}

	public void updateWinner(String winnerId, int bidPrice, String auctionId) throws DataAccessException {
		auctionMapper.updateWinner(winnerId, bidPrice, auctionId);
	}

	public Bid findWinnerBid(String auctionId) throws DataAccessException {
		return auctionMapper.findWinnerBid(auctionId);
	}
	
	public String getStatus(String auctionId) throws DataAccessException {
		return auctionMapper.getStatus(auctionId);
	}
	
	public void updateImmediatePurchase(String auctionId, int immdPurchasePrice, String winnerId) throws DataAccessException {
		auctionMapper.updateImmediatePurchase(auctionId, immdPurchasePrice, winnerId);
	}
	
	@Override
	public List<AuctionItemList> getFourAuctionItemList() throws DataAccessException {
		return auctionMapper.getFourAuctionItemList();
	}
}
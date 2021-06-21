package com.example.mnm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mnm.dao.AuctionDao;
import com.example.mnm.dao.CategoryDao;
import com.example.mnm.dao.CrowdFundingDao;
import com.example.mnm.dao.ItemDao;
import com.example.mnm.dao.PersonalDealDao;
import com.example.mnm.dao.AccountDao;
import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.AuctionItemList;
import com.example.mnm.domain.Bid;
import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.DealForm;
import com.example.mnm.domain.FundingForm;
import com.example.mnm.domain.Item;
import com.example.mnm.domain.LineItem;
import com.example.mnm.domain.Orders;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.domain.PersonalDealItemList;

@Service
@Transactional
public class MnmStoreImpl implements MnmStoreFacade { 
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired	
	private AccountDao accountDao;
	@Autowired
	private AuctionDao auctionDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired 
	private CrowdFundingDao crowdFundingDao;
	@Autowired 
	PersonalDealDao personalDealDao;
	@Autowired 
	private CategoryDao categoryDao;
	@Autowired
	private ThreadPoolTaskScheduler scheduler;

	// item
	public Item getItem(String itemId) {
		return itemDao.getItem(itemId);
	}
	public void insertItem(Item item) {
		itemDao.insertItem(item);
	}
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}
	public void deleteItem(String itemId) {
		itemDao.deleteItem(itemId);
	}
	public void increaseItemViews(String itemId) {
		itemDao.increaseItemViews(itemId);
	}
	public int getViews(String itemId) {
		return itemDao.getViews(itemId);
	}
	public Date getRegiDate(String itemId) {
		return itemDao.getRegiDate(itemId);
	}
	
	// category
	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}
	public String getCategoryName(String categoryId) {
		return categoryDao.getCategoryName(categoryId);
	}
	public Category getCategory(String categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	
	// 회원관리
	public void insertAccount(Account account) {
		logger.info("insertAccount()");
		accountDao.insertAccount(account);
	}
	public void deleteAccount(String userid) {
		logger.info("deleteAccount()");
		accountDao.deleteAccount(userid);
	}
	public void updateAccount(Account account) {
		logger.info("updateAccount()");
		accountDao.updateAccount(account);
	}
	public List<Account> getAccountList() {
		logger.info("getAccountList()");
		return accountDao.getAccountList();
	}
	public String getPwd(String id) {
		logger.info("getPwd()");
		return accountDao.getPwd(id);
	}
	public Account getAccount(String id) {
		logger.info("getAccount()");
		return accountDao.getAccount(id);
	}
	public String hasAccount(String id) {
		logger.info("hasAccount()");
		return accountDao.hasAccount(id);
	}
	
	// Auction
	public void insertAuctionItem(AuctionItem auctionItem) {
		auctionDao.insertAuctionItem(auctionItem);
	}
	public List<AuctionItemList> getRecentAuctionItemList() {
		return auctionDao.getRecentAuctionItemList();
	}
	public List<AuctionItemList> getPopularAuctionItemList() {
		return auctionDao.getPopularAuctionItemList();
	}
	public List<AuctionItemList> getMostBiddingAuctionItemList() {
		return auctionDao.getMostBiddingAuctionItemList();
	}
	public List<AuctionItemList> getClosingAuctionItemList() {
		return auctionDao.getClosingAuctionItemList();
	}
	public List<AuctionItemList> searchAuctionItemList(String word) {
		return auctionDao.searchAuctionItemList(word);
	}
	public AuctionItem getAuctionItem(String auctionId) {
		return auctionDao.getAuctionItem(auctionId);
	}
	public void updateAuctionItem(AuctionItem auctionItem) {
		auctionDao.updateAuctionItem(auctionItem);
	}
	public void deleteAuctionItem(String auctionId) {
		auctionDao.deleteAuctionItem(auctionId);
	}
	public void insertBidding(Bid bid) {
		auctionDao.insertBidding(bid);
	}
	public void updateCurrentPrice(String auctionId, int bidPrice) {
		auctionDao.updateCurrentPrice(auctionId, bidPrice);
	}
	public List<Bid> getBids(String auctionId) {
		return auctionDao.getBids(auctionId);
	}
	public String getStatus(String auctionId) {
		return auctionDao.getStatus(auctionId);
	}
	public void updateImmediatePurchase(String auctionId, int immdPurchasePrice, String winnerId) {
		auctionDao.updateImmediatePurchase(auctionId, immdPurchasePrice, winnerId);
	}
	public void updateGiveUpWinning(String auctionId, String userId) {
		auctionDao.updateGiveUpAuctionItem(auctionId);
		auctionDao.updateGiveUpBid(auctionId, userId);
	}
	public List<AuctionItemList> getSellingAuctionItemList(String userId) {
		return auctionDao.getSellingAuctionItemList(userId);
	}
	public List<AuctionItemList> getBiddingAuctionItemList(String userId) {
		return auctionDao.getBiddingAuctionItemList(userId);
	}
	public List<AuctionItemList> getAuctionedItemList(String userId) {
		return auctionDao.getAuctionedItemList(userId);
	}
	public Bid findSecondBid(String auctionId, String preWinnerId) {
		return auctionDao.findSecondBid(auctionId, preWinnerId);
	}
	public Bid findWinnerBid(String auctionId) {
		return auctionDao.findWinnerBid(auctionId);
	}
	public void updateWinner(String winnerId, int bidPrice, String auctionId, Date curTime) {
		auctionDao.updateWinner(winnerId, bidPrice, auctionId, curTime);
	}
	public void insertOrders(Orders orders) {
		auctionDao.insertOrders(orders);
	}
	public void insertLineItem(List<LineItem> lineItems) {
		auctionDao.insertLineItem(lineItems);
	}
	public void updateStatus(String status, String auctionId) {
		auctionDao.updateStatus(status, auctionId);
	}
	public Orders getAuctionOrder(int orderId) {
		return auctionDao.getAuctionOrder(orderId);
	}
	public int getOrderId(int itemId) {
		return auctionDao.getOrderId(itemId);
	}
	public void updateRebidding(String auctionId) {
		auctionDao.updateRebidding(auctionId);
	}
	public void startAuctionScheduler(Date startTime, String auctionId) {
		
		Runnable startAuctionItemRunner = new Runnable() {	
			// anonymous class 정의
			@Override
			public void run() {   // 스케쥴러에 의해 미래의 특정 시점에 실행될 작업을 정의		
				if (!auctionDao.getStatus(auctionId).equals("경매진행중") || !auctionDao.getStatus(auctionId).equals("결제완료")) {
					Date curTime = new Date();
					auctionDao.startAuctionItemStatus(curTime, auctionId);
					System.out.println("startAuctionItemRunner is executed at " + curTime);
				}
			}
		};

		// 스케줄 생성: startTime에 startAuctionItemRunner.run() 메소드 실행
		scheduler.schedule(startAuctionItemRunner, startTime);  
		
		System.out.println("startAuctionItemRunner has been scheduled to execute at " + startTime);
	}
	public void endAuctionScheduler(Date endTime, String auctionId) {
	
		Runnable endAuctionItemRunner = new Runnable() {	
			// anonymous class 정의
			@Override
			public void run() {   // 스케쥴러에 의해 미래의 특정 시점에 실행될 작업을 정의				
				Date curTime = new Date();
				if (auctionDao.getStatus(auctionId).equals("경매진행중")) {
					Bid bid = auctionDao.findWinnerBid(auctionId);
					if (bid != null) { // 입찰자가 있을 경우
						auctionDao.updateWinner(bid.getUserId(), bid.getBidPrice(), auctionId, curTime);
					}
					else { // 입찰자가 없는 경우
						auctionDao.updateFailedAuctionStatus(curTime, auctionId);
					}
				}
				System.out.println("endAuctionItemRunner is executed at " + curTime);
			}
		};

		// 스케줄 생성: endTime에 endAuctionItemRunner.run() 메소드 실행
		scheduler.schedule(endAuctionItemRunner, endTime);  
		
		System.out.println("endAuctionItemRunner has been scheduled to execute at " + endTime);
	}

	//CrowdFunding
	@Override
	public List<CrowdFundingItem> getCrowdFundingItemList() {
		return crowdFundingDao.getCrowdFundingItemList();
	}
	@Override
	public List<CrowdFundingItem> getCrowdFundingItemListRecently() {
		return crowdFundingDao.getCrowdFundingItemListRecently();
	}
	@Override
	public List<CrowdFundingItem> getCrowdFundingItemListMostViews() {
		return crowdFundingDao.getCrowdFundingItemMostViews();
	}
	@Override
	public List<CrowdFundingItem> getCrowdFundingItemListMostSponsors() {
		return crowdFundingDao.getCrowdFundingItemListMostSponsors();
	}
	@Override
	public List<CrowdFundingItem> getCrowdFundingItemListMostAmount() {
		return crowdFundingDao.getCrowdFundingItemListMostAmount();
	}
	@Override
	public List<CrowdFundingItem> getCrowdFundingItemListDeadLine() {
		return crowdFundingDao.getCrowdFundingItemListDeadLine();
	}
	@Override
	public List<CrowdFundingItem> getCrowdFundingItemListCategory(Category category) {
		return crowdFundingDao.getCrowdFundingItemListCategory(category);
	}

	@Override
	public CrowdFundingItem getFundingItemById(String crowdFundingId) {
		return crowdFundingDao.getFundingItemById(crowdFundingId);
	}
	
	@Override
	public List<CrowdFundingItem> getMyFundingItemListById(String userId) {
		return crowdFundingDao.getMyFundingItemListById(userId);
	}

	@Override
	public List<FundingForm> getMyFundingItemsCheckoutById(String userId) {
		return crowdFundingDao.getMyFundingItemsCheckoutById(userId);
	}
	
	@Override
	public void addFundingItem(CrowdFundingItem crowdFundingItem) {
		crowdFundingDao.addItem(crowdFundingItem.getItem());
		crowdFundingDao.addFundingItem(crowdFundingItem);
	}

	@Override
	public void removeFundingItemById(String itemId) {
		crowdFundingDao.removeFundingItemById(itemId);
	}

	@Override
	public void updateFundingItemById(String crowdFundingId, CrowdFundingItem crowdFundingItem) {
		crowdFundingDao.updateFundingItemById(crowdFundingId, crowdFundingItem);
		crowdFundingDao.updateItemById(crowdFundingItem.getItem().getItemId(), crowdFundingItem.getItem());
	}

	@Override
	public void fund(FundingForm fundingForm) {
		crowdFundingDao.fund(fundingForm);
		crowdFundingDao.fund2(fundingForm);
		crowdFundingDao.fundUpdate(fundingForm);
	}
	@Override
	public void cancelMyFundingItemsCheckout(FundingForm fundingForm) {
		crowdFundingDao.cancelMyFundingItemsCheckout(fundingForm);
		crowdFundingDao.cancel2(fundingForm);
		crowdFundingDao.cancelUpdate(fundingForm);
	}
	
	//PersonalDeal
	
	public List<PersonalDealItem> getAllPersonalDealItems() {
		return personalDealDao.getAllPersonalDealItems();
	}
	public List<PersonalDealItem> getPersonalDealItemList() {
		return personalDealDao.getPersonalDealItemList();
	}
	
	@Override
	public PersonalDealItem getPersonalDealItemById(String personalDealId) {
		return personalDealDao.getPersonalDealItemById(personalDealId);
	}
	
	@Override
	public void addPersonalDealItem(PersonalDealItem personalDealItem) {
		personalDealDao.addPersonalDealItem(personalDealItem);
		
	}
	
	@Override
	public void updatePersonalDealItem(PersonalDealItem personalDealItem) {
		personalDealDao.updatePersonalDealItem(personalDealItem);
	}
	public void finishDealById(int userId, PersonalDealItem personalDealItem) {
		personalDealDao.finishDealById(userId, personalDealItem);
	}
	@Override
	public List<PersonalDealItemList> searchPersonalDealItemList(String word) {
		
		return personalDealDao.searchPersonalDealItemList(word);
	}
	@Override
	public List<PersonalDealItemList> getNewestPersonalDealItemList() {
		
		return personalDealDao.getNewestPersonalDealItemList();
	}
	@Override
	public List<PersonalDealItemList> getPopularPersonalDealItemList() {
		
		return personalDealDao.getPopularPersonalDealItemList();
	}
	@Override
	public List<PersonalDealItemList> getLowestPricePersonalDealItemList() {
		
		return personalDealDao.getLowestPricePersonalDealItemList();
	}
	@Override
	public List<PersonalDealItemList> getHightestPricePersonalDealItemList() {
		
		return personalDealDao.getHightestPricePersonalDealItemList();
	}
	@Override
	public PersonalDealItem getPersonalDealItem(String personalDealId) {
		return personalDealDao.getPersonalDealItem(personalDealId);
	}
	@Override
	public void removePersonalDealItem(String personalDealId) {
		personalDealDao.removePersonalDealItem(personalDealId);
	}
	@Override
	public List<PersonalDealItem> getPersonalDealItemListById(String userId) {
		return personalDealDao.getPersonalDealItemListById(userId);
	}
	@Override
	public void purchase(DealForm dealForm) {
		personalDealDao.purchase(dealForm);
		//personalDealDao.purchase2(dealForm);	
	}
	@Override
	public void updatePurchase(String status, String personalDealId) {
		personalDealDao.updatePurchase(status, personalDealId);		
	}
	@Override
	public List<PersonalDealItem> getPurchasedPersonalDealItemListById(String userid) {
		return personalDealDao.getPurchasedPersonalDealItemListById(userid);
	}

	
	// 홈에 노출되는 아이템들 가져오기
	public List<PersonalDealItemList> getFourPersonalDealItemList() {
		logger.info("getFourPersonalDealItemList()");
		return personalDealDao.getFourPersonalDealItemList();
	}
	public List<AuctionItemList> getFourAuctionItemList() {
		logger.info("getFourAuctionItemList()");
		return auctionDao.getFourAuctionItemList();
	}
	public List<CrowdFundingItem> getFourCrowdFundingItemList() {
		logger.info("getFourCrowdFundingItemList()");
		return crowdFundingDao.getFourCrowdFundingItemList();
	}
	public List<PersonalDealItem> getRecommendedItemList(String fav) {
		logger.info("getRecommendedItemList()");
		return personalDealDao.getRecommendedItemList(fav);
	}

	
}
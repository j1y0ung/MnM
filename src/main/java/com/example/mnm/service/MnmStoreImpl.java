package com.example.mnm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

import java.util.List;
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
import com.example.mnm.domain.FundingForm;
import com.example.mnm.domain.Item;
import com.example.mnm.domain.PersonalDealItem;

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
		logger.info("[MnmStoreImpl INFO] insertAccount()");
		accountDao.insertAccount(account);
	}
	public void deleteAccount(String userid) {
		logger.info("[MnmStoreImpl INFO] deleteAccount()");
		accountDao.deleteAccount(userid);
	}
	public void updateAccount(Account account) {
		logger.info("[MnmStoreImpl INFO] updateAccount()");
		accountDao.updateAccount(account);
	}
	public List<Account> getAccountList() {
		logger.info("[MnmStoreImpl INFO] getAccountList()");
		return accountDao.getAccountList();
	}
	public String getPwd(String id) {
		logger.info("[MnmStoreImpl INFO] getPwd()");
		return accountDao.getPwd(id);
	}
	public Account getAccount(String id) {
		logger.info("[MnmStoreImpl INFO] getAccount()");
		return accountDao.getAccount(id);
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
	public void updateGiveUpWinning(String auctionId) {
		auctionDao.updateGiveUpWinning(auctionId);
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
	public void updateWinner(String winnerId, int bidPrice, String auctionId) {
		auctionDao.updateWinner(winnerId, bidPrice, auctionId);
	}
	public void startAuctionScheduler(Date startTime, String auctionId) {
		
		Runnable startAuctionItemRunner = new Runnable() {	
			// anonymous class 정의
			@Override
			public void run() {   // 스케쥴러에 의해 미래의 특정 시점에 실행될 작업을 정의		
				if (auctionDao.getStatus(auctionId).equals("경매대기중")) {
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
					String status = "";
					if (bid != null) {
						auctionDao.updateWinner(bid.getUserId(), bid.getBidPrice(), auctionId);
					}
					else {
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
	public List<CrowdFundingItem> getMyFundingItemsCheckoutById(String userId) {
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
		crowdFundingDao.removeItemById(itemId);
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
	
	// 홈에 노출되는 아이템들 가져오기
//	public List<PersonalDealItem> getFourPersonalDealItemList() {
//		logger.info("[MnmStoreImpl INFO] getFourPersonalDealItemList()");
//		return PersonalDealDao.getFourPersonalDealItemList();
//	}
	public List<AuctionItemList> getFourAuctionItemList() {
		logger.info("[MnmStoreImpl INFO] getFourAuctionItemList()");
		return auctionDao.getFourAuctionItemList();
	}
	public List<CrowdFundingItem> getFourCrowdFundingItemList() {
		logger.info("[MnmStoreImpl INFO] getFourCrowdFundingItemList()");
		return crowdFundingDao.getFourCrowdFundingItemList();
	}

	//PersonalDeal
	@Autowired PersonalDealDao personalDealDao;
	
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
	public void removePersonalDealItemById(String itemId) {
		personalDealDao.removePersonalDealItemById(itemId);
		personalDealDao.removeItemById(itemId);		
	}
	
	public void updatePersonalDealItemById(String personalDealId, PersonalDealItem personalDealItem) {
		personalDealDao.updatePersonalDealItemById(personalDealId, personalDealItem);
	}
	public void finishDealById(int userId, PersonalDealItem personalDealItem) {
		personalDealDao.finishDealById(userId, personalDealItem);
	}
	
	
}
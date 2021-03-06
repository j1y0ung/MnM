package com.example.mnm.dao.mybatis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.dao.ItemDao;
import com.example.mnm.dao.mybatis.mapper.ItemMapper;
import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.Item;
//import com.example.mnm.domain.LineItem;
//import com.example.mnm.domain.Order;

@Repository
public class MybatisItemDao implements ItemDao {
	@Autowired
	private ItemMapper itemMapper;
	
	public void insertItem(Item item) throws DataAccessException {
		itemMapper.insertItem(item);
	}
	
//	public void updateQuantity(Order order) throws DataAccessException {
//		for (int i = 0; i < order.getLineItems().size(); i++) {
//			LineItem lineItem = (LineItem) order.getLineItems().get(i);
//			String itemId = lineItem.getItemId();
//			Integer increment = new Integer(lineItem.getQuantity());
//			Map<String, Object> param = new HashMap<String, Object>(2);
//			param.put("itemId", itemId);
//			param.put("increment", increment);
//			itemMapper.updateInventoryQuantity(param);
//		}
//	}

	public boolean isItemInStock(String itemId) throws DataAccessException {
		return (itemMapper.getInventoryQuantity(itemId) > 0);
	}

	public List<Item> getItemListByProduct(String productId) 
			throws DataAccessException {
		return itemMapper.getItemListByProduct(productId);
	}

	public Item getItem(String itemId) throws DataAccessException {
		return itemMapper.getItem(itemId);
	}

	public void updateItem(Item item) throws DataAccessException {
		itemMapper.updateItem(item);
	}
	
	public void increaseItemViews(String itemId) throws DataAccessException {
		itemMapper.increaseItemViews(itemId);
	}
	
	public int getViews(String itemId) throws DataAccessException {
		return itemMapper.getViews(itemId);
	}
	
	public Date getRegiDate(String itemId) throws DataAccessException {
		return itemMapper.getRegiDate(itemId);
	}
	public void deleteItem(String itemId) throws DataAccessException {
		itemMapper.deleteItem(itemId);
	}
}

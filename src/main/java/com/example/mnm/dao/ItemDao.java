package com.example.mnm.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.Item;
//import com.example.mnm.domain.Order;

public interface ItemDao {
	
  public void insertItem(Item item) throws DataAccessException;

//  public void updateQuantity(Order order) throws DataAccessException;

  boolean isItemInStock(String itemId) throws DataAccessException;

  List<Item> getItemListByProduct(String productId) throws DataAccessException;

  Item getItem(String itemId) throws DataAccessException;
  
  void updateItem(Item item) throws DataAccessException;
  
  void increaseItemViews(String itemId) throws DataAccessException;
  
  int getViews(String itemId) throws DataAccessException;
  
  Date getRegiDate(String itemId) throws DataAccessException;
  
  void deleteItem(String itemId) throws DataAccessException;
}

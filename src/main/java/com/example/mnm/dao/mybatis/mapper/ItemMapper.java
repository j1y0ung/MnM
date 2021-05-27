package com.example.mnm.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.Item;

/**
 * @author Eduardo Macarron
 *
 */
@Mapper
public interface ItemMapper {

  void insertItem(Item item);
  
  void updateInventoryQuantity(Map<String, Object> param);

  int getInventoryQuantity(String itemId);

  List<Item> getItemListByProduct(String productId);

  Item getItem(String itemId);
  
  boolean isItemInStock(String itemId);
  
  void updateItem(Item item);
  
  void increaseItemViews(String itemId);
  
  int getViews(String itemId);
  
  Date getRegiDate(String itemId);
  
  void deleteItem(String itemId);

}

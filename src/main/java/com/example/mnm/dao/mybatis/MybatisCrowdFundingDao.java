package com.example.mnm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.dao.CrowdFundingDao;
import com.example.mnm.dao.mybatis.mapper.CrowdFundingMapper;
import com.example.mnm.domain.CrowdFundingItem;

@Repository
public class MybatisCrowdFundingDao implements CrowdFundingDao{
	
	@Autowired CrowdFundingMapper crowdFundingMapper;

	@Override
	public List<CrowdFundingItem> getAllFundingItems() throws DataAccessException {
		return crowdFundingMapper.getAllFundingItems();
	}

	@Override
	public List<CrowdFundingItem> getfundingItemList() throws DataAccessException {
		return crowdFundingMapper.getfundingItemList();
	}

	@Override
	public void addFundingItem(CrowdFundingItem crowdFundingItem) throws DataAccessException {
		crowdFundingMapper.addFundingItem(crowdFundingItem);
	}

	@Override
	public void removeFundingItemById(int id) throws DataAccessException {
		crowdFundingMapper.removeFundingItemById(id);
	}

	@Override
	public void updateFundingItemById(int id, CrowdFundingItem crowdFundingItem) throws DataAccessException {
		crowdFundingMapper.updateFundingItemById(id, crowdFundingItem);
	}

	@Override
	public void fund(int id) throws DataAccessException {
		crowdFundingMapper.fund(id);
	}


}

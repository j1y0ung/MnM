package com.example.mnm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.dao.CategoryDao;
import com.example.mnm.dao.mybatis.mapper.CategoryMapper;
import com.example.mnm.domain.Category;

@Repository
public class MybatisCategoryDao implements CategoryDao{
	
	@Autowired CategoryMapper categoryMapper;

	@Override
	public List<Category> getCategoryList() throws DataAccessException {
		return categoryMapper.getCategoryList();
	}

	@Override
	public Category getCategory(String categoryId) throws DataAccessException {
		return categoryMapper.getCategory(categoryId);
	}


}

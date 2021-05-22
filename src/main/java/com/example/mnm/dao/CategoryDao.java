package com.example.mnm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.Category;


public interface CategoryDao {

	public List<Category> getCategoryList() throws DataAccessException;

	public Category getCategory(String categoryId) throws DataAccessException;

}

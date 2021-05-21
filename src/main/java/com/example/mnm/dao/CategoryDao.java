package com.example.mnm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.Category;


public interface CategoryDao {

	List<Category> getCategoryList() throws DataAccessException;

	Category getCategory(String categoryId) throws DataAccessException;

}

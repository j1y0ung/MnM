package com.example.mnm.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.domain.Category;

@Repository
@Mapper
public interface CategoryMapper {
	
	List<Category> getCategoryList();
	
	String getCategoryName(String categoryId);
	
	Category getCategory(String categoryId);
	
}

package com.example.mnm.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.domain.Product;


@Repository
@Mapper
public interface ProductMapper {
	
	List<Product> getProductList() throws DataAccessException;
}

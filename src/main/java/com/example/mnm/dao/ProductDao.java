package com.example.mnm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.Product;


public interface ProductDao {

	public List<Product> getProductList() throws DataAccessException;

}

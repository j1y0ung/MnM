package com.example.mnm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.dao.ProductDao;
import com.example.mnm.dao.mybatis.mapper.ProductMapper;
import com.example.mnm.domain.Product;

@Repository
public class MybatisProductDao implements ProductDao{
	
	@Autowired ProductMapper productMapper;

	@Override
	public List<Product> getProductList() throws DataAccessException {
		return productMapper.getProductList();
	}

}

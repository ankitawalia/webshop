package com.tacton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.dao.ProductDao;
import com.tacton.entity.Product;
import com.tacton.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product findProductsByName(String productName) throws NoSuchProductException {
		Product product = productDao.findProductsByName(productName);
		return product;
		
	}

	@Override
	public void addProduct(Product product)
			throws NoSuchProductException {
		productDao.saveOrUpdate(product);
		
	}
	
	
	
}

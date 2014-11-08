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
	public void findProductsByName(String productName, int productId) throws NoSuchProductException {
		Product product = productDao.findProductsByName(productName);
		product.setProductId(productId);
		product.setProductName(productName);
		productDao.saveOrUpdate(product);
		
	}
	
}

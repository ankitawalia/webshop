package com.tacton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.dao.ProductDao;
import com.tacton.entity.Product;
import com.tacton.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findProductsByName(String productName) throws NoSuchProductException {
		List<Product> product = productDao.findProductsByName(productName);
		return product;
		
	}

	@Override
	public void addProduct(Product product)
			throws NoSuchProductException {
		productDao.saveOrUpdate(product);
		
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> product = productDao.findAllProducts();
		return product;
	}
	
	
}

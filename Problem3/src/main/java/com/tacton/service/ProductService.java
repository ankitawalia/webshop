package com.tacton.service;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.entity.Product;

public interface ProductService {
	
	public Product findProductsByName(String productName) throws NoSuchProductException;

	public void addProduct(Product product)throws NoSuchProductException;
}

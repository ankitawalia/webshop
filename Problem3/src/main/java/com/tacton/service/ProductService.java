package com.tacton.service;

import java.util.List;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.entity.Product;

public interface ProductService {
	
	public List<Product> findProductsByName(String productName) throws NoSuchProductException;

	public void addProduct(Product product)throws NoSuchProductException;

	public List<Product> findAllProducts();
}

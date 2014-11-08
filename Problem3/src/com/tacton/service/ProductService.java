package com.tacton.service;

import com.tacton.Exception.NoSuchProductException;

public interface ProductService {
	
	public void findProductsByName(String productName,int productId) throws NoSuchProductException;

}

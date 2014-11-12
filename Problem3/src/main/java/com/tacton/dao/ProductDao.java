package com.tacton.dao;

import java.util.List;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.entity.Product;


public interface ProductDao extends Dao<Product>{
	
	public List<Product> findProductsByName(Object value) throws NoSuchProductException;
	
	public List<Product> findAllProducts();
	
}

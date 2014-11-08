package com.tacton.dao;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.entity.Product;


public interface ProductDao extends Dao<Product>{
	
	public Product findProductsByName(Object value) throws NoSuchProductException;
	
}

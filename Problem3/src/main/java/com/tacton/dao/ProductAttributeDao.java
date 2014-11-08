package com.tacton.dao;

import java.util.List;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.entity.Attribute;
import com.tacton.entity.Product;
import com.tacton.entity.ProductAttribute;


public interface ProductAttributeDao extends Dao<ProductAttribute>{
	
	public ProductAttribute findAttributesValue(Product product,Attribute attribute) throws NoSuchProductException;
	
	public List<ProductAttribute> findAllAttributesForProduct(Product product);
}

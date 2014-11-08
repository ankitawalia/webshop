package com.tacton.dao;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.entity.ProductAttribute;


public interface ProductAttributeDao extends Dao<ProductAttribute>{
	
	public ProductAttribute findAttributesValue(int productId,int attributeId) throws NoSuchProductException;
	
}

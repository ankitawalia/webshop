package com.tacton.service;

import java.util.List;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.entity.ProductAttribute;

public interface ProductAttributeService {

    public ProductAttribute findAttributesValue(int productId,int attributeId) throws NoSuchAttributeException;
	
    public List<ProductAttribute> findAllAttributesForProduct(int productId);
}

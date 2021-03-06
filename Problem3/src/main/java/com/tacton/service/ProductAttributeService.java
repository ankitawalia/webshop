package com.tacton.service;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dto.ProductDetailsDTO;
import com.tacton.entity.ProductAttribute;

public interface ProductAttributeService {

    public ProductAttribute findAttributesValue(int productId,int attributeId) throws NoSuchAttributeException;
	
    public ProductDetailsDTO findAllAttributesForProduct(int productId);
}

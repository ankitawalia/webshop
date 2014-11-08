package com.tacton.service;

import java.util.List;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.entity.Attribute;
import com.tacton.entity.Product;
import com.tacton.entity.ProductAttribute;

public interface ProductAttributeService {

    public ProductAttribute findAttributesValue(Product product,Attribute attribute) throws NoSuchAttributeException;
	
    public List<ProductAttribute> findAllAttributesForProduct(Product product);
}

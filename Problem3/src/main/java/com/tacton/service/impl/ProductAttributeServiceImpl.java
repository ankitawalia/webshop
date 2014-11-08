package com.tacton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.ProductAttributeDao;
import com.tacton.entity.Attribute;
import com.tacton.entity.Product;
import com.tacton.entity.ProductAttribute;
import com.tacton.service.ProductAttributeService;

public class ProductAttributeServiceImpl implements ProductAttributeService {

	
	@Autowired
	private ProductAttributeDao productAttributeDao;
	
	@Override
	public ProductAttribute findAttributesValue(Product product,Attribute attribute)
			throws NoSuchAttributeException {
		ProductAttribute productAttribute = productAttributeDao.findAttributesValue(product,attribute);
		return productAttribute;
	}

	@Override
	public List<ProductAttribute> findAllAttributesForProduct(Product product) {
		List<ProductAttribute> productAttribute = productAttributeDao.findAllAttributesForProduct(product);
		return productAttribute;
	}
	

}

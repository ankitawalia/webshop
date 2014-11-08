package com.tacton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.ProductAttributeDao;
import com.tacton.entity.ProductAttribute;
import com.tacton.service.ProductAttributeService;

public class ProductAttributeServiceImpl implements ProductAttributeService {

	
	@Autowired
	private ProductAttributeDao productAttributeDao;
	
	@Override
	public ProductAttribute findAttributesValue(int productId,int attributeId)
			throws NoSuchAttributeException {
		ProductAttribute productAttribute = productAttributeDao.findAttributesValue(productId,attributeId);
		return productAttribute;
	}

}

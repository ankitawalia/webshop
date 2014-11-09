package com.tacton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.ProductAttributeDao;
import com.tacton.entity.ProductAttribute;
import com.tacton.service.ProductAttributeService;

@Service
@Transactional
public class ProductAttributeServiceImpl implements ProductAttributeService {

	
	@Autowired
	private ProductAttributeDao productAttributeDao;
	
	@Override
	public ProductAttribute findAttributesValue(int productId,int attributeId)
			throws NoSuchAttributeException {
		ProductAttribute productAttribute = productAttributeDao.findAttributesValue(productId,attributeId);
		return productAttribute;
	}

	@Override
	public List<ProductAttribute> findAllAttributesForProduct(int productId) {
		List<ProductAttribute> productAttribute = productAttributeDao.findAllAttributesForProduct(productId);
		return productAttribute;
	}
	

}

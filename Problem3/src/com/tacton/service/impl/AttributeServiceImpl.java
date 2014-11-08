package com.tacton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.AttributeDao;
import com.tacton.entity.Attribute;
import com.tacton.service.AttributeService;
import com.tacton.util.AttributeId;
import com.tacton.util.Type;

public class AttributeServiceImpl implements AttributeService {

	
	@Autowired
	private AttributeDao attributeDao;
	
	@Override
	public void findAttributesById(AttributeId attributeId, String attributeName, String attributeValue )
			throws NoSuchAttributeException {
		Attribute attribute = attributeDao.findAttributesById(attributeId);
		attribute.setAttributeName(attributeName);
		attribute.setAttributeId(attributeId.getId());
		attribute.setAttributeValue(attributeValue);
		attributeDao.saveOrUpdate(attribute);
	}

	@Override
	public void findAllAttributesByType(Type type)
			throws NoSuchAttributeException {
		Attribute attribute = attributeDao.findAllAttributesByType(type);
		attribute.setType(type);
		attributeDao.saveOrUpdate(attribute);
	}

}
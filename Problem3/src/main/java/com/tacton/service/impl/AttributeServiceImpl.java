package com.tacton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.AttributeDao;
import com.tacton.entity.Attribute;
import com.tacton.service.AttributeService;
import com.tacton.util.Type;

public class AttributeServiceImpl implements AttributeService {

	
	@Autowired
	private AttributeDao attributeDao;
	
	@Override
	public Attribute findAttributesById(int attributeId, String attributeName)
			throws NoSuchAttributeException {
		Attribute attribute = attributeDao.findAttributesById(attributeId);
		attribute.setAttributeName(attributeName);
		attribute.setAttributeId(attributeId);
		return attribute;
	}

	@Override
	public Attribute findAllAttributesByType(Type type)
			throws NoSuchAttributeException {
		Attribute attribute = attributeDao.findAllAttributesByType(type);
		attribute.setType(type);
		return attribute;
	}

}

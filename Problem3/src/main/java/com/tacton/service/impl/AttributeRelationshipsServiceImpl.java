package com.tacton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.AttributeRelationshipsDao;
import com.tacton.entity.Attribute;
import com.tacton.entity.AttributeRelationships;
import com.tacton.service.AttributeRelationshipsService;

public class AttributeRelationshipsServiceImpl implements AttributeRelationshipsService {
	
	@Autowired
	private AttributeRelationshipsDao attributeRelationshipsDao;

	@Override
	public List<AttributeRelationships> findAllAttributesinAttributeGroup(int parentId,Attribute attribute)
			throws NoSuchAttributeException {
		List<AttributeRelationships> attributeRelationships = attributeRelationshipsDao.
			findAllAttributesinAttributeGroup(parentId,attribute);
		return attributeRelationships;
	}
	
	
	

}

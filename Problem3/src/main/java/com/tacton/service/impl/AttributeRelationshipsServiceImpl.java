package com.tacton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.AttributeRelationshipsDao;
import com.tacton.entity.AttributeRelationships;
import com.tacton.service.AttributeRelationshipsService;

public class AttributeRelationshipsServiceImpl implements AttributeRelationshipsService {
	
	@Autowired
	private AttributeRelationshipsDao attributeRelationshipsDao;

	@Override
	public void findAllAttributesinAttributeGroup(int parentId, int order)
			throws NoSuchAttributeException {
	AttributeRelationships attributeRelationships = attributeRelationshipsDao.
			findAllAttributesinAttributeGroup(parentId);
	attributeRelationships.setOrder(order);
	attributeRelationships.setParentId(parentId);
		
	}
	
	
	

}

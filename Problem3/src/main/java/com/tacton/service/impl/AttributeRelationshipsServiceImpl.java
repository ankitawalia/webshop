package com.tacton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.AttributeRelationshipsDao;
import com.tacton.entity.AttributeRelationships;
import com.tacton.service.AttributeRelationshipsService;

@Service
@Transactional
public class AttributeRelationshipsServiceImpl implements AttributeRelationshipsService {
	
	@Autowired
	private AttributeRelationshipsDao attributeRelationshipsDao;

	@Override
	public List<AttributeRelationships> findAllAttributesinAttributeGroup(int parentId)
			throws NoSuchAttributeException {
		List<AttributeRelationships> attributeRelationships = attributeRelationshipsDao.
			findAllAttributesinAttributeGroup(parentId);
		return attributeRelationships;
	}
	
	
	

}

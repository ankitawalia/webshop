package com.tacton.service;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.entity.AttributeRelationships;


public interface AttributeRelationshipsService {

	public AttributeRelationships findAllAttributesinAttributeGroup(int parentId) throws NoSuchAttributeException;
}

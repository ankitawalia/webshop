package com.tacton.service;

import java.util.List;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.entity.Attribute;
import com.tacton.entity.AttributeRelationships;


public interface AttributeRelationshipsService {

	public List<AttributeRelationships> findAllAttributesinAttributeGroup(int parentId,Attribute attribute) throws NoSuchAttributeException;
}

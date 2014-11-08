package com.tacton.service;

import com.tacton.Exception.NoSuchAttributeException;


public interface AttributeRelationshipsService {

	public void findAllAttributesinAttributeGroup(int parentId,int order) throws NoSuchAttributeException;
}

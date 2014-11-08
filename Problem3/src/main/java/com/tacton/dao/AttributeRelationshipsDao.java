package com.tacton.dao;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.entity.AttributeRelationships;

public interface AttributeRelationshipsDao extends Dao<AttributeRelationships>{

	public AttributeRelationships findAllAttributesinAttributeGroup(Object value) throws NoSuchAttributeException;
	}

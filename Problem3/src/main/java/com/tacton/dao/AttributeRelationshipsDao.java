package com.tacton.dao;

import java.util.List;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.entity.AttributeRelationships;

public interface AttributeRelationshipsDao extends Dao<AttributeRelationships>{

	public List<AttributeRelationships> findAllAttributesinAttributeGroup(int parentId) throws NoSuchAttributeException;
	}

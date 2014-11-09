package com.tacton.dao;

import java.util.List;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.entity.Attribute;
import com.tacton.util.Type;

public interface AttributeDao extends Dao<Attribute>{

	public Attribute findAttributesById(Object value) throws NoSuchAttributeException;
	
	public List<Attribute> findAllAttributesByType(Type value) throws NoSuchAttributeException;
}

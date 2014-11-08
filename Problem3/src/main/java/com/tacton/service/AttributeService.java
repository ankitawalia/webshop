package com.tacton.service;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.entity.Attribute;
import com.tacton.util.Type;

public interface AttributeService {

    public Attribute findAttributesById(int attributeId) throws NoSuchAttributeException;
	
	public Attribute findAllAttributesByType(Type type) throws NoSuchAttributeException;
}

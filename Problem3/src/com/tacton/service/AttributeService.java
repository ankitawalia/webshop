package com.tacton.service;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.util.AttributeId;
import com.tacton.util.Type;

public interface AttributeService {

	
    public void findAttributesById(AttributeId attributeId, String attributeName, String attributeValue) throws NoSuchAttributeException;
	
	public void findAllAttributesByType(Type type) throws NoSuchAttributeException;
}

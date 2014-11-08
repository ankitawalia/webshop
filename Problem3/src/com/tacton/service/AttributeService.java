package com.tacton.service;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.util.Type;

public interface AttributeService {

	
    public void findAttributesById(int attributeId, String attributeName) throws NoSuchAttributeException;
	
	public void findAllAttributesByType(Type type) throws NoSuchAttributeException;
}

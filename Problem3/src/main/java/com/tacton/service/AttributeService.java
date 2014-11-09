package com.tacton.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.entity.Attribute;
import com.tacton.util.Type;

public interface AttributeService {

    public Attribute findAttributesById(int attributeId) throws NoSuchAttributeException;
	
	public List<Attribute> findAllAttributesByType(Type type) throws NoSuchAttributeException;
}

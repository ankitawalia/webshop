package com.tacton.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.AttributeDao;
import com.tacton.entity.Attribute;
import com.tacton.util.Type;

public class AttributeDaoImpl extends AbstractBaseDaoImpl<Attribute> implements AttributeDao{

	private static Logger logger = Logger.getLogger(AttributeDaoImpl.class);
	
	private String namedQueryString;

	@Override
	public String getNamedQueryString() {
		return namedQueryString;
	}

	@Override
	public Attribute findAttributesById(Object value)
			throws NoSuchAttributeException {
		logger.info("Finding attribute with Id:" +(int)value);
		this.namedQueryString = "getAttributesById";
		List<Attribute> attributeList = super.find("attributeId",value);
		if(attributeList.isEmpty())
		{
		 throw new NoSuchAttributeException("Attribute not present");	
		}
		return attributeList.get(0);
	}
	
	@Override
	public Attribute findAllAttributesByType(Type type)
			throws NoSuchAttributeException {
		logger.info("Finding attribute with Type:" +type);
		this.namedQueryString = "getAllAttributesByType";
		List<Attribute> attributesList = super.find("type",type);
		if(attributesList.isEmpty())
		{
		 throw new NoSuchAttributeException("Attribute not present");	
		}
		return attributesList.get(0);
	}
	
	
}

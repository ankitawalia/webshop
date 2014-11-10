package com.tacton.dto;

import java.util.Collection;

import com.tacton.entity.Attribute;

public class AttributeDTO {
	
private Integer attributeId;

private String attributeName;

private String attributeValue;

private Collection<AttributeDTO> childAttributeDTO;

public Integer getAttributeId() {
	return attributeId;
}

public void setAttributeId(Integer attributeId) {
	this.attributeId = attributeId;
}

public String getAttributeName() {
	return attributeName;
}

public void setAttributeName(String attributeName) {
	this.attributeName = attributeName;
}

public String getAttributeValue() {
	return attributeValue;
}

public void setAttributeValue(String attributeValue) {
	this.attributeValue = attributeValue;
}

public Collection<AttributeDTO> getChildAttributes() {
	return childAttributeDTO;
}

public void setChildAttributes(Collection<AttributeDTO> childAttributes) {
	this.childAttributeDTO = childAttributes;
}
	
}

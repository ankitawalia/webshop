package com.tacton.dto;

import java.util.List;

public class ProductDetailsDTO {
	
private Integer productId;

private String productName;

private List<AttributeDTO> attributeDTOs;

public Integer getProductId() {
	return productId;
}

public void setProductId(Integer productId) {
	this.productId = productId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public List<AttributeDTO> getAttributeDTOs() {
	return attributeDTOs;
}

public void setAttributeDTOs(List<AttributeDTO> attributeDTOs) {
	this.attributeDTOs = attributeDTOs;
}
	
}

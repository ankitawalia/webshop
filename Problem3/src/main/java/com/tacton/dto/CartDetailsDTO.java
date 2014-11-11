package com.tacton.dto;


import com.tacton.entity.Customer;
import com.tacton.entity.Organisation;

public class CartDetailsDTO {
	
private Integer cartId;

private Customer customer;

private Organisation org;

private ProductDetailsDTO productDetailsDTO;

public Integer getCartId() {
	return cartId;
}

public void setCartId(Integer cartId) {
	this.cartId = cartId;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public Organisation getOrg() {
	return org;
}

public void setOrg(Organisation org) {
	this.org = org;
}

public ProductDetailsDTO getProductDetailsDTO() {
	return productDetailsDTO;
}

public void setProductDetailsDTO(ProductDetailsDTO productDetailsDTO) {
	this.productDetailsDTO = productDetailsDTO;
}



}

package com.tacton.service;

import java.util.List;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.entity.Customer;
import com.tacton.entity.ShoppingCart;

public interface ShoppingCartService {

	public List<ShoppingCart> findShoppingCartById(Customer customerId) throws NoSuchShoppingCartException;
	
}

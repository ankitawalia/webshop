package com.tacton.service;

import com.tacton.Exception.NoSuchShoppingCartException;

public interface ShoppingCartService {

	public void findShoppingCartById(int cartId) throws NoSuchShoppingCartException;
	
}

package com.tacton.service;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.entity.ShoppingCart;

public interface ShoppingCartService {

	public ShoppingCart findShoppingCartById(int cartId) throws NoSuchShoppingCartException;
	
}

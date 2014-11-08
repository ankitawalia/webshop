package com.tacton.service;

import java.util.List;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.entity.ShoppingCart;

public interface ShoppingCartService {

	public List<ShoppingCart> findShoppingCartById(int cartId) throws NoSuchShoppingCartException;
	
}

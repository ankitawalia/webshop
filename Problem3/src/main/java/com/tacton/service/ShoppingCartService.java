package com.tacton.service;

import java.util.List;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.dto.CartDetailsDTO;
import com.tacton.entity.ShoppingCart;

public interface ShoppingCartService {

	//public List<ShoppingCart> findShoppingCartById(int customerId) throws NoSuchShoppingCartException;
	
	public CartDetailsDTO findShoppingCartById(int cartId) throws NoSuchShoppingCartException;
	
	public List<ShoppingCart> findAllShoppingCart();
	
}

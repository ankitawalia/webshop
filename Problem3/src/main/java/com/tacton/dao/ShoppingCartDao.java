package com.tacton.dao;

import java.util.List;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.entity.ShoppingCart;


public interface ShoppingCartDao extends Dao<ShoppingCart>{

	public List<ShoppingCart> findShoppingCartById(int customerId) throws NoSuchShoppingCartException;
	
	public List<ShoppingCart> findAllShoppingCart();
}

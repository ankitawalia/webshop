package com.tacton.dao;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.entity.ShoppingCart;


public interface ShoppingCartDao extends Dao<ShoppingCart>{

	public ShoppingCart findShoppingCartById(Object value) throws NoSuchShoppingCartException;
}

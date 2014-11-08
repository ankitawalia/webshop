package com.tacton.dao;

import java.util.List;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.entity.Customer;
import com.tacton.entity.ShoppingCart;


public interface ShoppingCartDao extends Dao<ShoppingCart>{

	public List<ShoppingCart> findShoppingCartById(Customer customerId) throws NoSuchShoppingCartException;
}

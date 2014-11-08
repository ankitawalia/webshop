package com.tacton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.dao.ShoppingCartDao;
import com.tacton.entity.ShoppingCart;
import com.tacton.service.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao shoppingCartDao;

	@Override
	public void findShoppingCartById(int cartId) throws NoSuchShoppingCartException {
		ShoppingCart shoppingCart = shoppingCartDao.findShoppingCartById(cartId);
		shoppingCart.setCustomerId(cartId);
		shoppingCartDao.saveOrUpdate(shoppingCart);
		
	}
	
}

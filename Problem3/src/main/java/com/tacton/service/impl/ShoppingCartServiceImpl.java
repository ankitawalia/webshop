package com.tacton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.dao.ShoppingCartDao;
import com.tacton.entity.ShoppingCart;
import com.tacton.service.ShoppingCartService;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao shoppingCartDao;

	@Override
	public List<ShoppingCart> findShoppingCartById(int cartId) throws NoSuchShoppingCartException {
		List<ShoppingCart> shoppingCart = shoppingCartDao.findShoppingCartById(cartId);
		return shoppingCart;
		
	}
	
}

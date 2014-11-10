package com.tacton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.dao.ShoppingCartDao;
import com.tacton.entity.ShoppingCart;
import com.tacton.service.ShoppingCartService;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao shoppingCartDao;

	@Override
	public List<ShoppingCart> findShoppingCartById(int customerId) throws NoSuchShoppingCartException {
		List<ShoppingCart> shoppingCart = shoppingCartDao.findShoppingCartById(customerId);
		return shoppingCart;
		
	}
	
	public List<ShoppingCart> findAllShoppingCart(){
		List<ShoppingCart> shoppingCart = shoppingCartDao.findAllShoppingCart();
		return shoppingCart;
	}
	
}

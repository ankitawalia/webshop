package com.tacton.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.dao.ShoppingCartDao;
import com.tacton.entity.ShoppingCart;

public class ShoppingCartDaoImpl extends AbstractBaseDaoImpl<ShoppingCart> implements ShoppingCartDao{

	private static Logger logger = Logger.getLogger(ShoppingCartDaoImpl.class);
	
	private String namedQueryString;

	@Override
	public String getNamedQueryString() {
		return namedQueryString;
	}

	@Override
	public ShoppingCart findShoppingCartById(Object value)
			throws NoSuchShoppingCartException {
		logger.info("Finding attribute with Id:" +(int)value);
		this.namedQueryString = "getShoppingCartById";
		List<ShoppingCart> shoppingCartList = super.find("cartId",value);
		if(shoppingCartList.isEmpty())
		{
		 throw new NoSuchShoppingCartException("Shopping Cart not present");	
		}
		return shoppingCartList.get(0);
	}
	
}

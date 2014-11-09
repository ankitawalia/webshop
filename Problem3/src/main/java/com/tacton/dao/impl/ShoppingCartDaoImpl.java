package com.tacton.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.dao.ShoppingCartDao;
import com.tacton.entity.Customer;
import com.tacton.entity.ShoppingCart;

public class ShoppingCartDaoImpl extends AbstractBaseDaoImpl<ShoppingCart> implements ShoppingCartDao{

	protected EntityManager em;

	 public ShoppingCartDaoImpl(EntityManager em) {
		    this.em = em;
		  }
	

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> findShoppingCartById(Customer customerId)
			throws NoSuchShoppingCartException {
		String queryString = "SELECT sc.cartId FROM shopping_cart sc,customer c where c.customer_Id=:customerId" ;
	    Query query = em.createQuery(queryString);
	    return query.getResultList();
	
	}
	
}

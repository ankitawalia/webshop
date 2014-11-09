package com.tacton.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.dao.ShoppingCartDao;
import com.tacton.entity.Customer;
import com.tacton.entity.ShoppingCart;

@Component
public class ShoppingCartDaoImpl extends AbstractBaseDaoImpl<ShoppingCart> implements ShoppingCartDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> findShoppingCartById(Customer customerId)
			throws NoSuchShoppingCartException {
		String queryString = "SELECT sc.cartId FROM shopping_cart sc,customer c where c.customer_Id=:customerId" ;
	    Query query = (Query)getHibernateSession().createSQLQuery(queryString).addEntity(ShoppingCart.class).setParameter("customerId",customerId);
	    return query.getResultList();
	
	}
	
}

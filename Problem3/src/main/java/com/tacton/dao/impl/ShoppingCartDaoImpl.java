package com.tacton.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.dao.ShoppingCartDao;
import com.tacton.entity.ShoppingCart;

@Component
public class ShoppingCartDaoImpl extends AbstractBaseDaoImpl<ShoppingCart> implements ShoppingCartDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> findShoppingCartById(int customerId)
			throws NoSuchShoppingCartException {
		String queryString = "SELECT * FROM shopping_cart sc where sc.customer_ref_id=:customerId" ;
	    Query query = getHibernateSession().createSQLQuery(queryString).addEntity(ShoppingCart.class).setParameter("customerId",customerId);
	    return query.list();
	
	}
	@Override
	public List<ShoppingCart> findAllShoppingCart(){
		String queryString = "SELECT * FROM shopping_cart sc" ;
	    Query query = getHibernateSession().createSQLQuery(queryString).addEntity(ShoppingCart.class);
	    return query.list();
	
	}
	
}

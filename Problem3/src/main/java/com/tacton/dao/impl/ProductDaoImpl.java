package com.tacton.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.Exception.NoSuchProductException;
import com.tacton.dao.ProductDao;
import com.tacton.entity.Attribute;
import com.tacton.entity.Product;
import com.tacton.util.Type;

@Component
public class ProductDaoImpl extends AbstractBaseDaoImpl<Product> implements ProductDao {

	private String namedQueryString;
	 
	@Override
	protected String getNamedQueryString() {
		return namedQueryString;
	}

	@Override
	public List<Product> findProductsByName(Object value)
			throws NoSuchProductException {
		this.namedQueryString = "getProductsByProductName";
		 List<Product> productList= super.find("productName", value);
		 if(productList.isEmpty())
		 {
			 throw new NoSuchProductException("Product not found");
		 }
		return productList;
	}

	@Override
	public List<Product> findAllProducts() {
		String queryString = "SELECT * from product";
	    Query query = getHibernateSession().createSQLQuery(queryString).addEntity(Product.class);
	    return query.list();
	}
	
	
}

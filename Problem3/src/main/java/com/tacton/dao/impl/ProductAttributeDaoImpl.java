package com.tacton.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.dao.ProductAttributeDao;
import com.tacton.entity.ProductAttribute;

public class ProductAttributeDaoImpl extends AbstractBaseDaoImpl<ProductAttribute> implements ProductAttributeDao {

	private String namedQueryString;
	
	protected EntityManager em;
	
	 public ProductAttributeDaoImpl(EntityManager em) {
		    this.em = em;
		  }
	 
	@Override
	protected String getNamedQueryString() {
		return namedQueryString;
	}

	@Override
	public ProductAttribute findAttributesValue(int productId,int attributeId)
			throws NoSuchProductException {
		String queryString = "SELECT pa.attribute_value FROM product_attributes pa " +
			 "WHERE pa.product_ref_id=:productId and pa.attribute_ref_id=:attribute_id" ;
	    Query query = em.createQuery(queryString);
	    return (ProductAttribute)query.getSingleResult();
		
	}

}

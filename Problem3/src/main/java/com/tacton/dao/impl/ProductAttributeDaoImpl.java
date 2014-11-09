package com.tacton.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.dao.ProductAttributeDao;
import com.tacton.entity.ProductAttribute;

@Component
public class ProductAttributeDaoImpl extends AbstractBaseDaoImpl<ProductAttribute> implements ProductAttributeDao {

	private String namedQueryString;
	 
	@Override
	protected String getNamedQueryString() {
		return namedQueryString;
	}

	@Override
	public ProductAttribute findAttributesValue(int productId,int attributeId)
			throws NoSuchProductException {
		String queryString = "SELECT a.attribute_name,pa.attribute_value FROM product_attributes pa,attribute a " +
			 "WHERE pa.product_ref_id=:productId and a.attribute_id=:attributeId" ;
	    Query query = (Query)getHibernateSession().createSQLQuery(queryString);
	    return (ProductAttribute)query.getSingleResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductAttribute> findAllAttributesForProduct(int productId) {
		String queryString = "SELECT a.attribute_name FROM product_attributes pa,attribute a " +
				 "WHERE pa.product_ref_id=:productId and pa.attribute_ref_id=a.attribute_id" ;
		    Query query = (Query)getHibernateSession().createSQLQuery(queryString);
		return query.getResultList();
	}

}

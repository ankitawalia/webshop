package com.tacton.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.dao.ProductAttributeDao;
import com.tacton.entity.Attribute;
import com.tacton.entity.Product;
import com.tacton.entity.ProductAttribute;

public class ProductAttributeDaoImpl extends AbstractBaseDaoImpl<ProductAttribute> implements ProductAttributeDao {

	private String namedQueryString;
	 
	@Override
	protected String getNamedQueryString() {
		return namedQueryString;
	}

	@Override
	public ProductAttribute findAttributesValue(Product productId,Attribute attributeId)
			throws NoSuchProductException {
		String queryString = "SELECT a.attribute_name,pa.attribute_value FROM product_attributes pa,attribute a " +
			 "WHERE pa.product_ref_id=:productId and a.attribute_id=:attributeId" ;
	    Query query = em().createQuery(queryString);
	    return (ProductAttribute)query.getSingleResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductAttribute> findAllAttributesForProduct(Product productId) {
		String queryString = "SELECT a.attribute_name FROM product_attributes pa,attribute a " +
				 "WHERE pa.product_ref_id=:productId and pa.attribute_ref_id=a.attribute_id" ;
		    Query query = em().createQuery(queryString);
		return query.getResultList();
	}

}

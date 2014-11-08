package com.tacton.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.AttributeRelationshipsDao;
import com.tacton.entity.AttributeRelationships;

public class AttributeRelationshipsDaoImpl extends AbstractBaseDaoImpl<AttributeRelationships> implements AttributeRelationshipsDao{
	
	private String namedQueryString;
	
	protected EntityManager em;

	 public AttributeRelationshipsDaoImpl(EntityManager em) {
		    this.em = em;
		  }

	@Override
	public String getNamedQueryString() {
		return namedQueryString;
	}

	@Override
	public AttributeRelationships findAllAttributesinAttributeGroup(Object value)
			throws NoSuchAttributeException {
		    String queryString = "SELECT * FROM attribute_relationships ar GROUP BY ar.parent_id" ;
		    Query query = em.createQuery(queryString);
		    return (AttributeRelationships)query.getResultList();
	}

}
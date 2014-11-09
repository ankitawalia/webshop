package com.tacton.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.AttributeRelationshipsDao;
import com.tacton.entity.Attribute;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<AttributeRelationships> findAllAttributesinAttributeGroup(int parentId, Attribute attributeId)
			throws NoSuchAttributeException {
		    String queryString = "SELECT ar.child_Id,a.attribute_name FROM attribute_relationships ar" +
			     ",attribute a where ar.parent_id = :parentId and a.attribute_id= :attributeId" ;
		    Query query = em.createQuery(queryString);
		    return query.getResultList();
	}

}

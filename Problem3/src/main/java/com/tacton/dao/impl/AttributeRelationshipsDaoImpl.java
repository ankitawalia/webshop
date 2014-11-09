package com.tacton.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.AttributeRelationshipsDao;
import com.tacton.entity.AttributeRelationships;

@Component
public class AttributeRelationshipsDaoImpl extends AbstractBaseDaoImpl<AttributeRelationships> implements AttributeRelationshipsDao{
	
	private String namedQueryString;
	

	@Override
	public String getNamedQueryString() {
		return namedQueryString;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AttributeRelationships> findAllAttributesinAttributeGroup(int parentId)
			throws NoSuchAttributeException {
		    String queryString = "SELECT * FROM attribute_relationships ar" +
			     " where parent_id = :parentId" ;
		    Query query = getHibernateSession().createSQLQuery(queryString).addEntity(AttributeRelationships.class);
		    query.setParameter("parentId", parentId);
		    return query.list();
	}

}

package com.tacton.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.tacton.dao.OrganisationDao;
import com.tacton.entity.Attribute;
import com.tacton.entity.Organisation;

@Service
public class OrganisationDaoImpl extends AbstractBaseDaoImpl<Attribute> implements OrganisationDao{

	private String namedQueryString;

	@Override
	public String getNamedQueryString() {
		return namedQueryString;
	}


	@Override
	public Organisation findOrganisationById(int orgId) {
		String queryString = "SELECT * from organisation where id=:orgId" ;
	    Query query = getHibernateSession().createSQLQuery(queryString).addEntity(Organisation.class).setParameter("orgId", orgId);
	    return (Organisation) query.list().get(0);
	}

	@Override
	public List<Organisation> findAllOrganisations() {
		String queryString = "SELECT * from organisation" ;
	    Query query = getHibernateSession().createSQLQuery(queryString).addEntity(Organisation.class);
	    List<Organisation> orgList =  query.list();
	    return orgList;
	}

	@Override
	public List<Organisation> findAllOrganisations(int parentOrgId) {
		String queryString = "SELECT * from organisation where parent_id=:parentOrgId" ;
	    Query query = getHibernateSession().createSQLQuery(queryString).addEntity(Organisation.class);
	    query.setParameter("parentOrgId", parentOrgId);
	    return query.list();
	}
	
	
}

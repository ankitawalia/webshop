package com.tacton.dao;

import java.util.List;

import com.tacton.entity.Organisation;

public interface OrganisationDao {

	public Organisation findOrganisationById(int orgId);

	public List<Organisation> findAllOrganisations() ;

	public List<Organisation> findAllOrganisations(int parentOrgId) ;

}

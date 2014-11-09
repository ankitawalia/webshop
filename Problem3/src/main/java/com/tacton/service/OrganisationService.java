package com.tacton.service;

import java.util.List;

import com.tacton.entity.Organisation;

public interface OrganisationService {

    public Organisation findOrganisationById(int orgId);
    
    public List<Organisation> findAllOrganisations();
    
    public List<Organisation> findChildOrganisations(int parentOrgId);
	
}

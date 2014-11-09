package com.tacton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacton.dao.OrganisationDao;
import com.tacton.entity.Organisation;
import com.tacton.service.OrganisationService;

@Service
@Transactional
public class OrganisationServiceImpl implements OrganisationService {

	@Autowired
	private OrganisationDao orgDao;
	
	@Override
	public Organisation findOrganisationById(int orgId) {
		return orgDao.findOrganisationById(orgId);
	}

	@Override
	public List<Organisation> findAllOrganisations() {
		return orgDao.findAllOrganisations();
	}

	@Override
	public List<Organisation> findChildOrganisations(int parentOrgId) {
		return orgDao.findAllOrganisations(parentOrgId);
	}

	

}

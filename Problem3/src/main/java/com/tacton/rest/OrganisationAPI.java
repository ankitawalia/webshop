package com.tacton.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.tacton.entity.Organisation;
import com.tacton.service.OrganisationService;

@Path("/organisation")
@Component
public class OrganisationAPI extends SpringBeanAutowiringSupport {
	
	@Autowired
	private OrganisationService organisationService;
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<Organisation> getAllOrganisations() {
		List<Organisation> attribList = organisationService.findAllOrganisations(); 
		return attribList;
	}
	
	@GET
	@Path("/child/{id}")
	@Produces("application/json")
	public List<Organisation> getAllChildOrganisations(@PathParam("id") int id) {
		List<Organisation> attribList = organisationService.findChildOrganisations(id);
		return attribList;
	}

}
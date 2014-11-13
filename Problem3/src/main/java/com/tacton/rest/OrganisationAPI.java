package com.tacton.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.google.common.collect.TreeTraverser;
import com.tacton.dto.OrganisationDTO;
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
	public List<OrganisationDTO> getAllOrganisations() {
		List<Organisation> attribList = organisationService.findAllOrganisations(); 
		List<OrganisationDTO> organisationTree = getOrganisationTreeStructure(attribList);
		return organisationTree;
	}
	
	private List<OrganisationDTO> getOrganisationTreeStructure(
			List<Organisation> attribList) {
		final List<OrganisationDTO> organisationTree = new ArrayList<>();
		@SuppressWarnings("unused")
		Integer previousOrgId = null; 
		int row = 1;
    	int column = 1;
    	Map<Integer, Integer> orgLevel =  new HashMap<>();
		TreeTraverser<Organisation> traverser = new TreeTraverser<Organisation>() {
			
		    @Override
		    public Iterable<Organisation> children(Organisation org) {
		    	
		        return org.getChildOrgs();
		    }
		};
		for (Organisation org : traverser.preOrderTraversal(attribList.get(0))){
			OrganisationDTO orgDto = new OrganisationDTO();
	    	orgDto.setOrgName(org.getOrgName());
	    	
	    	orgDto.setMaxRow(row);
	    	orgDto.setRow(row++);
	    	orgDto.setColumn(orgLevel.get(org.getParentId()) == null ? column : orgLevel.get(org.getParentId()));
	    	orgDto.setMaxColumn(column);
	    	if(orgLevel.get(org.getParentId()) == null){
	    		orgLevel.put(org.getParentId(), column++) ;
	    	}
	    	previousOrgId = org.getParentId();
	    	organisationTree.add(orgDto);
		}
		return organisationTree;
	}

	@GET
	@Path("/child/{id}")
	@Produces("application/json")
	public List<Organisation> getAllChildOrganisations(@PathParam("id") int id) {
		List<Organisation> attribList = organisationService.findChildOrganisations(id);
		return attribList;
	}

}
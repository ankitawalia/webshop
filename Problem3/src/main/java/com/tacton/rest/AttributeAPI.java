package com.tacton.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.tacton.entity.Attribute;
import com.tacton.service.AttributeService;
import com.tacton.util.Type;

@Path("/attributes")
@Component
public class AttributeAPI extends SpringBeanAutowiringSupport {
	
	@Autowired
	private AttributeService attributeService;

	@GET
	@Path("/group")
	@Produces("application/json")
	public List<Attribute> getAllAttributesGroup() {
		List<Attribute> attribList = attributeService.findAllAttributesByType(Type.ATTRIBUTE_GROUP); 
		return attribList;
	}

}
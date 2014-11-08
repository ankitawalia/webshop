package com.tacton.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.entity.Attribute;
import com.tacton.service.AttributeService;

@Path("/attribute")
public class AttributeAPI {
	
	@Autowired
	private AttributeService attributeService;

	@GET
	@Path("/get/all")
	@Produces("application/json")
	public Attribute getAttributesInJSON() {

		Attribute attr = new Attribute();
		attr.setAttributeName("test");
		return attr; 

	}

}
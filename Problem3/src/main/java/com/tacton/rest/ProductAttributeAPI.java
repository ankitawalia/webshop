package com.tacton.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.tacton.dto.ProductDetailsDTO;
import com.tacton.entity.Product;
import com.tacton.service.ProductAttributeService;
import com.tacton.service.ProductService;

@Path("/product")
@Component
public class ProductAttributeAPI extends SpringBeanAutowiringSupport {
	
	@Autowired
	private ProductAttributeService productAttributeService;
	
	@Autowired
	private ProductService productService;

	@GET
	@Path("/getallproducts")
	@Produces("application/json")
	public List<Product> getAllProduct() {
		List<Product> attribList = productService.findAllProducts(); 
		return attribList;
	}

	@GET
	@Path("/getallproducts/{id}")
	@Produces("application/json")
	public ProductDetailsDTO getAllAttributesForProduct(@PathParam("id") int id) {
		ProductDetailsDTO attribList = productAttributeService.findAllAttributesForProduct(id); 
		return attribList;
	}

}
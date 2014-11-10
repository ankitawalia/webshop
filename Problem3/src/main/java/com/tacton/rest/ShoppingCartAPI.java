package com.tacton.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.tacton.entity.Customer;
import com.tacton.entity.ShoppingCart;
import com.tacton.service.CustomerService;
import com.tacton.service.ShoppingCartService;

@Path("/cart")
@Component
public class ShoppingCartAPI extends SpringBeanAutowiringSupport {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private CustomerService customerService;

	@GET
	@Path("/details")
	@Produces("application/json")
	public List<ShoppingCart> getAllCarts() {
		List<ShoppingCart> attribList = shoppingCartService.findAllShoppingCart(); 
		return attribList;
	}
	
	@GET
	@Path("/details/{id}")
	@Produces("application/json")
	public Customer getCustomerDetails(@PathParam("id") int id) {
		Customer attribList = customerService.findCustomerForOrg(id); 
		return attribList;
	}
	
}
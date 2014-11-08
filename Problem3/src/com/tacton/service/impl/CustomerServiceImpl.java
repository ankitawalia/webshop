package com.tacton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.Exception.NoSuchCustomerException;
import com.tacton.dao.CustomerDao;
import com.tacton.entity.Customer;
import com.tacton.service.CustomerService;
import com.tacton.util.CustomerId;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public void findCustomerById(CustomerId customerId, String customerName, String customerAddress, int organisationId) throws NoSuchCustomerException {
		Customer customer = customerDao.findCustomerById(customerId);
		customer.setCustomerId(customerId.getId());
		customer.setCustomerName(customerName);
		customer.setCustomerAddress(customerAddress);
		customer.setOrganisationId(organisationId);
		customerDao.saveOrUpdate(customer);
		
	}
	
}

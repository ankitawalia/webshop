package com.tacton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.Exception.NoSuchCustomerException;
import com.tacton.dao.CustomerDao;
import com.tacton.entity.Customer;
import com.tacton.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer findCustomerById(int customerId) throws NoSuchCustomerException {
		Customer customer = customerDao.findCustomerById(customerId);
		return customer;
		
	}
	
}

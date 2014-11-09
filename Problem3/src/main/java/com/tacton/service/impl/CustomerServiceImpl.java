package com.tacton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacton.Exception.NoSuchCustomerException;
import com.tacton.dao.CustomerDao;
import com.tacton.entity.Customer;
import com.tacton.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer findCustomerById(int customerId) throws NoSuchCustomerException {
		Customer customer = customerDao.findCustomerById(customerId);
		return customer;
		
	}
	
}

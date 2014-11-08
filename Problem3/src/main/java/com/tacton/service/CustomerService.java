package com.tacton.service;

import com.tacton.Exception.NoSuchCustomerException;
import com.tacton.entity.Customer;

public interface CustomerService {
    
	public Customer findCustomerById(int customerId, String customerName, String customerAddress, int organisationId) throws NoSuchCustomerException;
	
}

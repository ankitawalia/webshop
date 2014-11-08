package com.tacton.service;

import com.tacton.Exception.NoSuchCustomerException;
import com.tacton.entity.Customer;

public interface CustomerService {
    
	public Customer findCustomerById(int customerId) throws NoSuchCustomerException;
	
}

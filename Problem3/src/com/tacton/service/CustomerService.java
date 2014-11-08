package com.tacton.service;

import com.tacton.Exception.NoSuchCustomerException;
import com.tacton.util.CustomerId;

public interface CustomerService {
    
	public void findCustomerById(CustomerId customerId, String customerName, String customerAddress, int organisationId) throws NoSuchCustomerException;
	
}

package com.tacton.service;

import com.tacton.Exception.NoSuchCustomerException;

public interface CustomerService {
    
	public void findCustomerById(int customerId, String customerName, String customerAddress, int organisationId) throws NoSuchCustomerException;
	
}

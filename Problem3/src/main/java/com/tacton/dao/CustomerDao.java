package com.tacton.dao;

import com.tacton.Exception.NoSuchCustomerException;
import com.tacton.entity.Customer;

public interface CustomerDao extends Dao<Customer>{
	
	public Customer findCustomerById(Object value) throws NoSuchCustomerException;
		
}

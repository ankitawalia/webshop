package com.tacton.dao;

import com.tacton.Exception.NoSuchCustomerException;
import com.tacton.entity.Customer;

public interface CustomerDao extends Dao<Customer>{
	
	public Customer findCustomerById(String propertyName, Object value) throws NoSuchCustomerException;
	
	
	
}

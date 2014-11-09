package com.tacton.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.tacton.Exception.NoSuchCustomerException;
import com.tacton.dao.CustomerDao;
import com.tacton.entity.Customer;

@Component
public class CustomerDaoImpl extends AbstractBaseDaoImpl<Customer> implements CustomerDao {
	
	private static Logger logger = Logger.getLogger(CustomerDaoImpl.class);

    private String namedQueryString;
	
	@Override
	protected String getNamedQueryString() {
		return namedQueryString;
	}
	@Override
	public Customer findCustomerById(Object value)  {
		logger.info("Finding customer with Id" + (int)value);
		this.namedQueryString = "getCustomerByCustomerId";
		List<Customer> customerList = super.find("customerId", value);
		if(customerList.isEmpty()) {
			throw new NoSuchCustomerException("Customer not found") ;
		}
		return customerList.get(0);
	}

}

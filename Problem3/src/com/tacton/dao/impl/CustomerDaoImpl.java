package com.tacton.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.tacton.Exception.NoSuchCustomerException;
import com.tacton.dao.CustomerDao;
import com.tacton.entity.Customer;

public class CustomerDaoImpl extends AbstractBaseDaoImpl<Customer> implements CustomerDao {
	
	private static Logger logger = Logger.getLogger(CustomerDao.class);

    private String namedQueryString;
	
	@Override
	protected String getNamedQueryString() {
		return namedQueryString;
	}
	@Override
	public Customer findCustomerById(String propertyName, Object value)  {
		logger.info("Finding customer with Id" + value.toString());
		this.namedQueryString = "getCustomerByCustomerId";
		List<Customer> customerList = super.find(propertyName, value);
		if(customerList.isEmpty()) {
			throw new NoSuchCustomerException("Customer not found") ;
		}
		return customerList.get(0);
	}

}

package com.tacton.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.tacton.dao.CustomerDao;
import com.tacton.entity.Customer;

@Component
public class CustomerDaoImpl extends AbstractBaseDaoImpl<Customer> implements CustomerDao {
	

	@Override
	public Customer findCustomerById(int customerId)  {
		
			String queryString = "SELECT * FROM customer where customer_id= :customerId";
		    Query query = getHibernateSession().createSQLQuery(queryString).addEntity(Customer.class);
		    return (Customer) query.list().get(0);
	}
	
	@Override
	public Customer findCustomerForOrg(int orgId)  {
		
			String queryString = "SELECT * FROM customer where cust_org_id= :orgId";
		    Query query = getHibernateSession().createSQLQuery(queryString).addEntity(Customer.class);
		    return (Customer) query.list().get(0);
	}
	

}

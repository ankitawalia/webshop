package com.tacton.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tacton.dao.CustomerDao;
import com.tacton.dao.ProductDao;
import com.tacton.service.OrderingService;

public class OrderingServiceImpl implements OrderingService {
	
	private static Logger logger = Logger.getLogger(OrderingService.class);
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	
}

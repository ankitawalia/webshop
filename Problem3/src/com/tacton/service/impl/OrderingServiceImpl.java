package com.tacton.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tacton.entity.Customer;
import com.tacton.entity.Product;
import com.tacton.service.OrderingService;

public class OrderingServiceImpl implements OrderingService {
	
	private static Logger logger = Logger.getLogger(OrderingService.class);
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	
}

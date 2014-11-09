package com.tacton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.AttributeDao;
import com.tacton.entity.Attribute;
import com.tacton.service.AttributeService;
import com.tacton.util.Type;

@Service(value="attributeService")
public class AttributeServiceImpl implements AttributeService {

	
	@Autowired
	private AttributeDao attributeDao;
	
	@Override
	@Transactional
	public Attribute findAttributesById(int attributeId)
			throws NoSuchAttributeException {
		Attribute attribute = attributeDao.findAttributesById(attributeId);
		return attribute;
	}

	@Override
	@Transactional
	public List<Attribute>  findAllAttributesByType(Type type)
			throws NoSuchAttributeException {
		return  attributeDao.findAllAttributesByType(type);
	}

}

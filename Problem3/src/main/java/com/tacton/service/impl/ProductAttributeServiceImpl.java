package com.tacton.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.tacton.Exception.NoSuchAttributeException;
import com.tacton.dao.AttributeRelationshipsDao;
import com.tacton.dao.ProductAttributeDao;
import com.tacton.dto.AttributeDTO;
import com.tacton.dto.ProductDetailsDTO;
import com.tacton.entity.AttributeRelationships;
import com.tacton.entity.ProductAttribute;
import com.tacton.service.ProductAttributeService;
import com.tacton.util.Type;

@Service
@Transactional
public class ProductAttributeServiceImpl implements ProductAttributeService {

	@Autowired
	private ProductAttributeDao productAttributeDao;

	@Autowired
	private AttributeRelationshipsDao attributeRelationshipsDao;

	@Override
	public ProductAttribute findAttributesValue(int productId, int attributeId)
			throws NoSuchAttributeException {
		ProductAttribute productAttribute = productAttributeDao
				.findAttributesValue(productId, attributeId);
		return productAttribute;
	}

	@Override
	public ProductDetailsDTO findAllAttributesForProduct(int productId) {
		List<ProductAttribute> productAttributes = productAttributeDao
				.findAllAttributesForProduct(productId);
		ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
		final Map<Integer, String> mapProductIdValue= new HashMap<>();
		for (ProductAttribute productAttribute : productAttributes) {
			if(!Type.ATTRIBUTE_GROUP.equals(productAttribute.getAttributeId().getType()))
			mapProductIdValue.put(productAttribute.getAttributeId().getAttributeId(), productAttribute.getAttributeValue());
		}
		final List<Integer> idsToExclude = new ArrayList<>();
		List<AttributeDTO> attributeSet = new ArrayList<>();
		for (ProductAttribute productAttribute : productAttributes) {
			productDetailsDTO.setProductId(productAttribute.getProductId()
					.getProductId());
			productDetailsDTO.setProductName(productAttribute.getProductId()
					.getProductName());
			AttributeDTO attributeDTO = new AttributeDTO();
			if (Type.ATTRIBUTE_GROUP.equals(productAttribute.getAttributeId()
					.getType())) {
				
				Collection<AttributeDTO> childAttributes = getChildAttributes(productAttribute.getAttributeId().getAttributeId()
					, mapProductIdValue);
				
				attributeDTO.setAttributeId(productAttribute.getAttributeId()
						.getAttributeId());
				attributeDTO.setAttributeName(productAttribute.getAttributeId()
						.getAttributeName());
				attributeDTO.setChildAttributes(childAttributes);
				setIdsToExclude(childAttributes, idsToExclude);

			} else if (!idsToExclude.contains(productAttribute.getAttributeId().getAttributeId())){
				attributeDTO.setAttributeId(productAttribute.getAttributeId()
						.getAttributeId());
				attributeDTO.setAttributeName(productAttribute.getAttributeId()
						.getAttributeName());
				attributeDTO.setAttributeValue(productAttribute.getAttributeValue());
			}
			if(attributeDTO.getAttributeId()!=null) {
				attributeSet.add(attributeDTO);
			}
			productDetailsDTO.setAttributeDTOs(attributeSet);
		}
		return productDetailsDTO;
	}

	private void setIdsToExclude(Collection<AttributeDTO> childAttributes, List<Integer> idsToExclude) {
		for(AttributeDTO childAttribute :  childAttributes) {
			idsToExclude.add(childAttribute.getAttributeId());
			if(childAttribute.getChildAttributes() != null && !childAttribute.getChildAttributes().isEmpty()) {
				setIdsToExclude(childAttribute.getChildAttributes(), idsToExclude);
			}
		}		
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	private Collection<AttributeDTO>  getChildAttributes(
			int attribId, final Map<Integer, String> mapProductIdValue) {
		List<AttributeRelationships> attributeRelationships = attributeRelationshipsDao
				.findAllAttributesinAttributeGroup(attribId);
		Collection<AttributeDTO> childAttributes = Collections2.transform(
				attributeRelationships,
				new Function<AttributeRelationships, AttributeDTO>() {
					@Override
					public AttributeDTO apply(AttributeRelationships input) {
						AttributeDTO attributeDTO = new AttributeDTO();
						attributeDTO.setAttributeId(input.getChildId().getAttributeId());
						attributeDTO.setAttributeName(input.getChildId().getAttributeName());
						attributeDTO.setAttributeValue(mapProductIdValue.get(input.getChildId().getAttributeId()));
						if(Type.ATTRIBUTE_GROUP.equals(input.getChildId().getType())) {
							attributeDTO.setChildAttributes(getChildAttributes(input.getChildId().getAttributeId(), mapProductIdValue));
						}
						return attributeDTO;
					}
				});
		childAttributes.size();	
		return childAttributes;
	}

}

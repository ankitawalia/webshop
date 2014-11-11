package com.tacton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacton.Exception.NoSuchShoppingCartException;
import com.tacton.dao.ShoppingCartDao;
import com.tacton.dto.CartDetailsDTO;
import com.tacton.entity.ShoppingCart;
import com.tacton.service.ProductAttributeService;
import com.tacton.service.ShoppingCartService;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	@Autowired
	private ProductAttributeService productAttributeService;

	@Override
	public CartDetailsDTO findShoppingCartById(int customerId) throws NoSuchShoppingCartException {
		ShoppingCart shoppingCart = shoppingCartDao.findShoppingCartById(customerId);
		CartDetailsDTO cartDetailsDTO = new CartDetailsDTO();
		cartDetailsDTO.setCustomer(shoppingCart.getCustomerId());
		cartDetailsDTO.setOrg(shoppingCart.getCustomerId().getOrganisation());
		cartDetailsDTO.setProductDetailsDTO(productAttributeService.findAllAttributesForProduct(shoppingCart.getProduct().getProductId()));
		return cartDetailsDTO;
		
	}
	
	public List<ShoppingCart> findAllShoppingCart(){
		List<ShoppingCart> shoppingCart = shoppingCartDao.findAllShoppingCart();
		return shoppingCart;
	}
	
}

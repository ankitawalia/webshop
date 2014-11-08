package com.tacton.dao.impl;

import java.util.List;

import com.tacton.Exception.NoSuchProductException;
import com.tacton.dao.ProductDao;
import com.tacton.entity.Product;

public class ProductDaoImpl extends AbstractBaseDaoImpl<Product> implements ProductDao {

	private String namedQueryString;
	
	@Override
	protected String getNamedQueryString() {
		return namedQueryString;
	}

	@Override
	public Product findProductsByName(Object value)
			throws NoSuchProductException {
		this.namedQueryString = "getProductsByProductName";
		 List<Product> productList= super.find("productName", value);
		 if(productList.isEmpty())
		 {
			 throw new NoSuchProductException("Product not found");
		 }
		return productList.get(0);
	}

	


}

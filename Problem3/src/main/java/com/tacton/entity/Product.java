package com.tacton.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product",schema="tacton")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -616837476986369128L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	public int productId;
	
	@Column(name="product_name")
	public String productName;
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	
	    public String toString() {
	
	        return new StringBuffer(" Product Id : ").append(this.productId)
	
	                .append(" Product Name : ").append(this.productName).toString();

	    }


	
}

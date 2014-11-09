package com.tacton.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="product_attributes",schema="tacton")
public class ProductAttribute implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name="product_ref_id")
	private Product product;
	
	@JoinColumn(name="attribute_ref_id")
	private Attribute attribute;
	
	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Column(name="order")
	private int order;
	
	@Column(name="attribute_value")
	private String attributeValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
}

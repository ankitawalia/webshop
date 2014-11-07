package com.tacton.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="attribute",schema="tacton")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Attribute implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="attribute_id", nullable=false,unique=true)
	private String attributeId;
	
	@Column(name="attribute_name")
	private String attributeName;
	
	@Column(name="attribute_value")
	private String attributeValue;
	
	@Column(name="type")
	private String type;
	
	@ManyToMany
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}

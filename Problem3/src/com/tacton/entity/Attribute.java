package com.tacton.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import com.tacton.util.Type;

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
	private String attributeId;
	
	@Column(name="attribute_name")
	private String attributeName;
	
	@Column(name="attribute_value")
	private String attributeValue;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private Type type;

	@ManyToMany
	private Product product;

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
	
	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
		
	}

	
	/*public void setType(Type type) {
		for(Type attributeTypes: Type.values()){
			this.type = attributeTypes;
	}
		
	}
*/
	
}

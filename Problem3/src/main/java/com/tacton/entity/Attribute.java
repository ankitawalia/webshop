package com.tacton.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tacton.util.Type;

@Entity
@Table(name="attribute",schema="tacton")
public class Attribute implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="attribute_id")
	private int attributeId;
	
	@Column(name="attribute_name")
	private String attributeName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private Type type;

	public int getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
		
	}

}

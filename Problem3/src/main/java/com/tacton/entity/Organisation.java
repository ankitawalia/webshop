package com.tacton.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="organisation",schema="tacton")
public class Organisation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="parent_id")
	private Organisation parentId;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="parent_id")
	private List<Organisation> childOrgs; 
	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Organisation getParentId() {
		return parentId;
	}

	public void setParentId(Organisation parentId) {
		this.parentId = parentId;
	}

	public List<Organisation> getChildOrgs() {
		return childOrgs;
	}

	public void setChildOrgs(List<Organisation> childOrgs) {
		this.childOrgs = childOrgs;
	}
	
}

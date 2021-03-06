package com.tacton.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "organisation", schema = "tacton")
public class Organisation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column(name = "parent_id")
	private Integer parentId;

	@OneToMany(mappedBy = "parentId", fetch=FetchType.EAGER)
	private Set<Organisation> childOrgs;

	@Column(name = "org_name")
	private String orgName;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Set<Organisation> getChildOrgs() {
		return childOrgs;
	}

	public void setChildOrgs(Set<Organisation> childOrgs) {
		this.childOrgs = childOrgs;
	}

}

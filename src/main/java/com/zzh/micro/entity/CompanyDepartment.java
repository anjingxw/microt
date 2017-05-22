package com.zzh.micro.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "t_department")
@Entity
public class CompanyDepartment  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long   departmentID;
	@Column(nullable = false, unique = true)
	private String departmentName;
	
	@ManyToOne 
	@JoinColumn(name="companyID")  
	@NotNull  
	private Company company;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)  
	@JoinColumn(name="departmentID")
	private Set<User> users = new HashSet<User>();


	public Long getDepartmentID() {
		return departmentID;
	}


	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}

}

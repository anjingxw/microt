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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "t_company")
@Entity
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long companyID;
	@Column(nullable = false)
	private Long companyType;
	@Column(nullable = false, unique = true)
	private String companyName;
	@Column(nullable = false)
	private long createTime;
	@Column(nullable = true)
	private String state;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)  
	@JoinColumn(name="companyID")//注释的是另一个表指向本表的外键。
	private Set<User> users = new HashSet<User>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)  
	@JoinColumn(name="companyID")//注释的是另一个表指向本表的外键。
	private Set<CompanyDepartment> departments = new HashSet<CompanyDepartment>();
	
	public Set<User> getUsers() {
		return users;
	}

	public Long getCompanyID() {
		return companyID;
	}
	public void setCompanyID(Long i) {
		this.companyID = i;
	}
	public Long getCompanyType() {
		return companyType;
	}
	public void setCompanyType(Long companyType) {
		this.companyType = companyType;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}

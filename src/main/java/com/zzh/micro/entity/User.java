package com.zzh.micro.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 用户
 * @author 
 *
 */
@Entity
@Table(name = "t_user")
public class User  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long   userID;
	@Column(nullable = false, unique = true)
	private String loginName;
	@Column(nullable = false)
	private String password;
	@Column(nullable = true)
	private String displayName;
	@Column(nullable = true)
	private long lastLoginTime;
	@Column(nullable = true)
	private String lastLoginIp;
	@Column(nullable = true)
	private Long   errorLogin;
	@Column(nullable = true)
	private Long   loginCnt;
	@Column(nullable = false)
	private long createTime;
	@Column(nullable = false)
	private String expiryDate;
	@Column(nullable = true)
	private String appLoginToken;
	@Column(nullable = true)
	private Long   fingerprintVerification;
	
	@ManyToOne 
	@JoinColumn(name="companyID")  
	@NotNull  
	private Company company;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_user_role"
	, inverseJoinColumns={@JoinColumn(name="roles", referencedColumnName="roleID")} 
	, joinColumns ={@JoinColumn(name="users", referencedColumnName="userID")})
	private Set<Role> roles = new HashSet<>();
	
	public void setFingerprintVerification(Long fingerprintVerification) {
		this.fingerprintVerification = fingerprintVerification;
	}


	public Long getUserID() {
		return userID;
	}


	public void setUserID(Long userID) {
		this.userID = userID;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	public long getLastLoginTime() {
		return lastLoginTime;
	}


	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}


	public String getLastLoginIp() {
		return lastLoginIp;
	}


	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}


	public Long getErrorLogin() {
		return errorLogin;
	}


	public void setErrorLogin(Long errorLogin) {
		this.errorLogin = errorLogin;
	}


	public Long getLoginCnt() {
		return loginCnt;
	}


	public void setLoginCnt(Long loginCnt) {
		this.loginCnt = loginCnt;
	}


	public long getCreateTime() {
		return createTime;
	}


	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	public String getAppLoginToken() {
		return appLoginToken;
	}


	public void setAppLoginToken(String appLoginToken) {
		this.appLoginToken = appLoginToken;
	}


	public Long getFingerprintVerification() {
		return fingerprintVerification;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "userName " + this.loginName + ", pasword " + this.displayName;
	}
}

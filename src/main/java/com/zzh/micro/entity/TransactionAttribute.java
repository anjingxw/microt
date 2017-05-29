package com.zzh.micro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_transaction_attribute")
public class TransactionAttribute {
	@Id
	@GeneratedValue
	private Long   transactionAttributeID;
	@Column(nullable = false, unique = true)
	private String transactionAttributeName;
	
	@Column(nullable = false)
	private Long companyID;
	
	@Column(nullable = false)
	private Long createUserID;
	
	@Column(nullable = false)
	private long createTime;

	public Long getTransactionAttributeID() {
		return transactionAttributeID;
	}

	public void setTransactionAttributeID(Long transactionAttributeID) {
		this.transactionAttributeID = transactionAttributeID;
	}

	public String getTransactionAttributeName() {
		return transactionAttributeName;
	}

	public void setTransactionAttributeName(String transactionAttributeName) {
		this.transactionAttributeName = transactionAttributeName;
	}

	public Long getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Long companyID) {
		this.companyID = companyID;
	}

	public Long getCreateUserID() {
		return createUserID;
	}

	public void setCreateUserID(Long createUserID) {
		this.createUserID = createUserID;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	
}

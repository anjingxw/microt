package com.zzh.micro.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {

	@Id
	@GeneratedValue
	private Long transactionID;
	@Column(nullable= false)
	private String title;
	@Column(nullable = false)
	private Long transactionAttributeID;
	@Column (nullable = false)
	private Long level;
	@Column (nullable = false)
	private String content;
	@Column(nullable = false)
	private Long   companyID;
	@Column(nullable = false)
	private Long   departmentID;
	@Column(nullable = false)
	private Long   createTime;
	@Column(nullable = false)
	private Long createUserID;
	@Column(nullable = false)
	private Long   startsTime;
	@Column(nullable = false)
	private Long   endTime;
	
	@OneToMany
	private Set<TransactionTransfer>  transfers;
	
}

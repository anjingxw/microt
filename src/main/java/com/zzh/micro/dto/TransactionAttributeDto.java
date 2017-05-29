package com.zzh.micro.dto;

public class TransactionAttributeDto {
	private Long    transactionAttributeID;
	private String  transactionAttributeName;
	private Long    createTime;
	private String  createUserName;

	public TransactionAttributeDto(Long transactionAttributeID, String transactionAttributeName, Long createTime,
			String createUserName) {
		super();
		this.transactionAttributeID = transactionAttributeID;
		this.transactionAttributeName = transactionAttributeName;
		this.createTime = createTime;
		this.createUserName = createUserName;
	}
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
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
}

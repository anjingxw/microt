package com.zzh.micro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_file_attribute")
public class FileAttribute {
	@Id
	@GeneratedValue
	private Long   fileAttributeID;
	@Column(nullable = false, unique = true)
	private String fileAttributeName;
	
	@Column(nullable = false)
	private Long companyID;
	
	@Column(nullable = false)
	private Long createUserID;
	
	@Column(nullable = false)
	private long createTime;

	public Long getFileAttributeID() {
		return fileAttributeID;
	}

	public void setFileAttributeID(Long fileAttributeID) {
		this.fileAttributeID = fileAttributeID;
	}

	public String getFileAttributeName() {
		return fileAttributeName;
	}

	public void setFileAttributeName(String fileAttributeName) {
		this.fileAttributeName = fileAttributeName;
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

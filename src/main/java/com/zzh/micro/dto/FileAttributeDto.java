package com.zzh.micro.dto;

public class FileAttributeDto {
	private Long    fileAttributeID;
	private String  fileAttributeName;
	private Long    createTime;
	private String  createUserName;
	
	public FileAttributeDto(Long fileAttributeID, String fileAttributeName, Long createTime, String createUserName) {
		super();
		this.fileAttributeID = fileAttributeID;
		this.fileAttributeName = fileAttributeName;
		this.createTime = createTime;
		this.createUserName = createUserName;
	}
	
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

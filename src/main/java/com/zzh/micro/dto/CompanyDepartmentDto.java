package com.zzh.micro.dto;
public class CompanyDepartmentDto{
	private Long    departmentID;
	private String  departmentName;
	private Long    createTime;
	private String  createUserName;
	
	public CompanyDepartmentDto(){	
	}
	
	public CompanyDepartmentDto(Long departmentID, String departmentName, Long createTime, String createUserName){
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.createTime = createTime;
		this.createUserName = createUserName;
	}
	
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

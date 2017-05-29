package com.zzh.micro.dto;

public class UserDto {
private Long    userID;
private String  loginName;
private String  companyName;
private String  departmentName;
private boolean valid;
private String  createUserName;
private long    createTime;

public UserDto(Long userID, String loginName, String companyName, String departmentName, boolean valid,
		String createUserName, long createTime) {
	super();
	this.userID = userID;
	this.loginName = loginName;
	this.companyName = companyName;
	this.departmentName = departmentName;
	this.valid = valid;
	this.createUserName = createUserName;
	this.createTime = createTime;
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
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public boolean isValid() {
	return valid;
}
public void setValid(boolean valid) {
	this.valid = valid;
}
public String getCreateUserName() {
	return createUserName;
}
public void setCreateUserName(String createUserName) {
	this.createUserName = createUserName;
}
public long getCreateTime() {
	return createTime;
}
public void setCreateTime(long createTime) {
	this.createTime = createTime;
}



}

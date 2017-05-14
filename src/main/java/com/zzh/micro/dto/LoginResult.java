package com.zzh.micro.dto;

public class LoginResult {
	private Long   UserID;
	private String LoginName;
	private String token;
	
	public LoginResult(Long userID, String loginName, String token) {
		super();
		UserID = userID;
		LoginName = loginName;
		this.token = token;
	}
	public Long getUserID() {
		return UserID;
	}
	public void setUserID(Long userID) {
		UserID = userID;
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}

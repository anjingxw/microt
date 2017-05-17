package com.zzh.micro.dto;

public class UserInfo {
	private Long   userID;
	private String loginName;
	private String displayName;
	private String avatars;
	private Long   rating;
	private String token;
	
	public UserInfo(Long userID, String loginName, String displayName,String avatars, Long rating, String token) {
		super();
		this.userID = userID;
		this.loginName = loginName;
		this.displayName = displayName;
		this.rating = rating;
		this.avatars = avatars;
		this.token = token;
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
	public String getDisplayName() {
		if (displayName == null) {
			return loginName;
		}
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getAvatars() {
		return avatars;
	}

	public void setAvatars(String avatars) {
		this.avatars = avatars;
	}
}

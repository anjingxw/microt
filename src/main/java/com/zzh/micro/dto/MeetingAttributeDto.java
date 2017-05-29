package com.zzh.micro.dto;

public class MeetingAttributeDto {
	private Long    meetingAttributeID;
	private String  meetingAttributeName;
	private Long    createTime;
	private String  createUserName;
	
	public MeetingAttributeDto() {
	}
	
	public MeetingAttributeDto(Long meetingAttributeID, String meetingAttributeName, Long createTime,
			String createUserName) {
		super();
		this.meetingAttributeID = meetingAttributeID;
		this.meetingAttributeName = meetingAttributeName;
		this.createTime = createTime;
		this.createUserName = createUserName;
	}
	public Long getMeetingAttributeID() {
		return meetingAttributeID;
	}
	public void setMeetingAttributeID(Long meetingAttributeID) {
		this.meetingAttributeID = meetingAttributeID;
	}
	public String getMeetingAttributeName() {
		return meetingAttributeName;
	}
	public void setMeetingAttributeName(String meetingAttributeName) {
		this.meetingAttributeName = meetingAttributeName;
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

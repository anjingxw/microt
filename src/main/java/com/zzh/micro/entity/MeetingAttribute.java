package com.zzh.micro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_meeting_attribute")
public class MeetingAttribute{
	@Id
	@GeneratedValue
	private Long   meetingAttributeID;
	@Column(nullable = false, unique = true)
	private String meetingAttributeName;
	
	@Column(nullable = false)
	private Long companyID;
	
	@Column(nullable = false)
	private Long createUserID;
	
	@Column(nullable = false)
	private long createTime;

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

package com.zzh.micro.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_meetting")
public class Meetting {
	@Id
	@GeneratedValue
	private Long meetingID;
	
	@Column(nullable = false, unique = false)
	private String  title;
	
	@Column(nullable = false)
	private Long meetingAttributeID;
	@Column(nullable = false)
	private Integer level;
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
	@Column(nullable = false)
	private Long   state;
	@Column(nullable = false)
	private String content;
	@Column(nullable = false)
	private String need;//参会要求
	@Column(nullable = false)
	private String address;//参会要求
	
	@ManyToOne
	@JoinColumn(name = "transactionID")
	Transaction transaction;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)  
	@JoinColumn(name="meetingID")
	private Set<Attach> attachs = new HashSet<Attach>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_meeting_user"
	, joinColumns={@JoinColumn(name="meetings", referencedColumnName="meetingID")} //表在中间表中的列名
	, inverseJoinColumns ={@JoinColumn(name="users", referencedColumnName="userID")}) //指定受控方的列名
	private Set<User> users = new HashSet<>();
}

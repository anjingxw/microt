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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="t_notice")
public class Notice {
	@Id
	@GeneratedValue
	private Long  noticeID;
	
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private Long type; //类别
	@Column(nullable = false)
	private Long level; //紧急程度
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
	private Long state;
	@Column(nullable = false)
	private String content;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)  
	@JoinColumn(name="noticeID")
	private Set<Attach> attachs = new HashSet<Attach>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_notice_readuser"
	, joinColumns={@JoinColumn(name="readNotices", referencedColumnName="noticeID")} //表在中间表中的列名
	, inverseJoinColumns ={@JoinColumn(name="readUsers", referencedColumnName="userID")}) //指定受控方的列名
	private Set<User> readUsers = new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_notice_unreaduser"
	, joinColumns={@JoinColumn(name="unreadNotices", referencedColumnName="noticeID")} //表在中间表中的列名
	, inverseJoinColumns ={@JoinColumn(name="unreadUsers", referencedColumnName="userID")}) //指定受控方的列名
	private Set<User> unreadUsers = new HashSet<>();

}

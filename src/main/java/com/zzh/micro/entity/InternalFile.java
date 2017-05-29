package com.zzh.micro.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_internal_file")
public class InternalFile {
	@Id
	@GeneratedValue
	private Long  internalFileID;
	@Column(nullable = false)
	private Long   companyID;
	@Column(nullable = false)
	private Long   departmentID;
	@Column(nullable = false)
	private Long   createTime;
	@Column(nullable = false)
	private Long   endTime;
	@Column(nullable = false)
	private Long   fileAttribute;
	@Column(nullable = false)
	private String  title;
	@Column(nullable = true)
	private String  detail;
	@Column(nullable = false)
	private Long   security;
	@Column(nullable = false)
	private boolean  released;
	@Column(nullable = false)
	private String attachment;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_user_internalfile"
	, joinColumns={@JoinColumn(name="internalFiles", referencedColumnName="internalFileID")} //表在中间表中的列名
	, inverseJoinColumns ={@JoinColumn(name="users", referencedColumnName="userID")}) //指定受控方的列名
	private Set<User> users = new HashSet<>();

}

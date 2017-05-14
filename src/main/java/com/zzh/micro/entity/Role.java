package com.zzh.micro.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleID;

	@Column(nullable = false, unique =true)
	private String roleName;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_user_role"
	, joinColumns={@JoinColumn(name="roles", referencedColumnName="roleID")} //表在中间表中的列名
	, inverseJoinColumns ={@JoinColumn(name="users", referencedColumnName="userID")}) //指定受控方的列名
	private Set<User> users = new HashSet<>();
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

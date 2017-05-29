package com.zzh.micro.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_transaction_process")
public class TransactionTransfer {
	@Id
	@GeneratedValue
	private Long  transactionProcessID;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_transaction_process_mainuser"
	, joinColumns={@JoinColumn(name="mainTransactions", referencedColumnName="transactionProcessID")} //表在中间表中的列名
	, inverseJoinColumns ={@JoinColumn(name="mainUsers", referencedColumnName="userID")}) //指定受控方的列名
	private Set<User> mainUsers = new HashSet<>();
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_transaction_process_helpuser"
	, joinColumns={@JoinColumn(name="helpTransactions", referencedColumnName="transactionProcessID")} //表在中间表中的列名
	, inverseJoinColumns ={@JoinColumn(name="helpUsers", referencedColumnName="userID")}) //指定受控方的列名
	private Set<User> helpUsers = new HashSet<>();

	
	@OneToOne
	private TransactionFinish transactionFinish;
}

package com.zzh.micro.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_transaction_finish")
public class TransactionFinish {
	@Id
	@GeneratedValue
	private Long  transactionFinishID;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private Long   state;//完成， 完成90%， 未完成
	
	@OneToOne
	private TransactionTransfer transactionTransfer;
	
	@OneToMany
	@JoinColumn
	private Set<Attach> attachs;
	
}

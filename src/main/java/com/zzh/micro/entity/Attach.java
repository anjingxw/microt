package com.zzh.micro.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_attach")
public class Attach {
	@Id
	@GeneratedValue
	private Long  attachID;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String path;
	@Column(nullable=true)
	private String originTilte;
	@Column(nullable=true)
	private String tips;
	
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "meetingID")
    private Meetting meetting;
    
	
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "noticeID")
    private Notice notice;
	
}

package com.zzh.micro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_company_department")
@Entity
public class CompanyDepartment {

	@Id
	@GeneratedValue
	private Long   companyDepartmentID;
	@Column(nullable = false, unique = true)
	private String departmentName;
}

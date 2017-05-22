package com.zzh.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzh.micro.entity.CompanyDepartment;

public interface CompanyDepartmentReprository extends JpaRepository<CompanyDepartment, Long>{
}

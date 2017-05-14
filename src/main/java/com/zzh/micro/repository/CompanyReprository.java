package com.zzh.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzh.micro.entity.Company;
import com.zzh.micro.entity.User;

public interface CompanyReprository extends JpaRepository<Company, Long>{
	User findByCompanyID(Long id);
}

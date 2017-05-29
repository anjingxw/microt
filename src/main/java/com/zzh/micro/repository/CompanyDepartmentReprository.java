package com.zzh.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zzh.micro.dto.CompanyDepartmentDto;
import com.zzh.micro.entity.CompanyDepartment;

public interface CompanyDepartmentReprository extends JpaRepository<CompanyDepartment, Long>{
	public String findSql = "select new com.zzh.micro.dto.CompanyDepartmentDto(d.departmentID, d.departmentName, d.createTime, up.displayName) from CompanyDepartment d, User u, UserProperty up where d.createUserID = u.userID and u.property = up.userPropertyID";
	
	@Query(findSql)
	Page<CompanyDepartmentDto> findAllDto(Pageable pageable);
	
	@Transactional
	@Modifying
	@Query("delete from CompanyDepartment where departmentID = ?1")
	int deleteByDepartmentID(Long departmentID);
	
	@Modifying
	@Transactional
	@Query("update CompanyDepartment u set u.departmentName = ?1 where u.departmentID = ?2")
	int modifyById(String  departmentName, Long departmentID);
}

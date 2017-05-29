package com.zzh.micro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zzh.micro.dto.UserDto;
import com.zzh.micro.entity.User;
public interface  UserReprository extends JpaRepository<User, Long>{
	String findSql =  "select new com.zzh.micro.dto.UserDto(u.userID, u.loginName, c.companyName, d.departmentName, u.valid, up.displayName, c.createTime)"
				+ " from User u, Company c, CompanyDepartment d, UserProperty up"
				+ " where u.company = c.companyID and u.department = d.departmentID and u.property = up.userPropertyID";
	
	@Query(findSql)
	Page<UserDto> findAllDto(Pageable pageable);
	
	User findByUserID(Long id);
	User findByLoginName(String loginName);
}

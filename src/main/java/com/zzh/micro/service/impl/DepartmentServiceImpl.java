package com.zzh.micro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzh.micro.dto.CompanyDepartmentDto;
import com.zzh.micro.dto.Result;
import com.zzh.micro.entity.CompanyDepartment;
import com.zzh.micro.entity.User;
import com.zzh.micro.repository.CompanyDepartmentReprository;
import com.zzh.micro.repository.UserReprository;
import com.zzh.micro.service.DepartmentService;
import com.zzh.micro.util.DateUtils;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired 
	UserReprository userReprository;  
	@Autowired
	CompanyDepartmentReprository  departmentReprository;
	
	public Result<java.util.List<CompanyDepartment>>  List(){
		return new Result<java.util.List<CompanyDepartment>>(true, departmentReprository.findAll());
	}
	
	@Override
	public Result<Long> Add(String  name, Long loginId) {
		User user = userReprository.findByUserID(loginId);
		CompanyDepartment department = new CompanyDepartment();
		department.setCompany(user.getCompany());
		department.setDepartmentName(name);
		department.setCreateUserID(user.getUserID());
		department.setCreateTime(DateUtils.getCurrentTime());
		departmentReprository.save(department);
		return new Result<Long>(true, department.getDepartmentID());
	}
	
	public Result<Boolean>  Update(Long departmentId, String  name){
		departmentReprository.modifyById(name, departmentId);
		return new Result<Boolean>(true, true);
	}
	
	@Transactional
	public Result<Boolean>  Delete(Long departmentId){
		departmentReprository.deleteByDepartmentID(departmentId);
		return new Result<Boolean>(true, true);
	}
	
	public Page<CompanyDepartmentDto> findAllDto(Pageable pageable){
		return departmentReprository.findAllDto(pageable);
	}
}

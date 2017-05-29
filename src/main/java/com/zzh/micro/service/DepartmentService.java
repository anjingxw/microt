package com.zzh.micro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zzh.micro.dto.CompanyDepartmentDto;
import com.zzh.micro.dto.Result;
import com.zzh.micro.entity.CompanyDepartment;


public interface DepartmentService {
	Page<CompanyDepartmentDto> findAllDto(Pageable pageable);
	public Result<java.util.List<CompanyDepartment>>  List();
	public Result<Long>  Add(String  name, Long loginId);
	public Result<Boolean>  Update(Long departmentId, String  name);
	public Result<Boolean>  Delete(Long departmentId);
}

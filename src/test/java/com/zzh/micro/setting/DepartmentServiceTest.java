package com.zzh.micro.setting;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.zzh.micro.BaseTest;
import com.zzh.micro.dto.CompanyDepartmentDto;
import com.zzh.micro.repository.CompanyDepartmentReprository;
import com.zzh.micro.service.DepartmentService;
public class DepartmentServiceTest extends BaseTest{
	
	@Autowired
	DepartmentService  departmentService;
	
	@Autowired
	CompanyDepartmentReprository departmentReprository;
	
	@Test
	public void add(){
		int page=0,size=3;
		Sort sort = new Sort(Direction.DESC, "id");
	    Pageable pageable = new PageRequest(page, size, sort);
	    Page<CompanyDepartmentDto> test = departmentService.findAllDto(pageable);
		assertEquals(test.getSize(), 3);
		Long addId = departmentService.Add("test", 1L).getData();
		assertEquals("test", departmentReprository.findOne(addId).getDepartmentName());
		departmentService.Update(addId, "D");
		assertEquals("D", departmentReprository.findOne(addId).getDepartmentName());
		departmentService.Delete(addId);
		assertEquals(false, departmentReprository.exists(addId));
	}
    
}

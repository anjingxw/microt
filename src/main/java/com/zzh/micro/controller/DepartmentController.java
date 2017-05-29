package com.zzh.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzh.micro.dto.Result;
import com.zzh.micro.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController {
	@Autowired
	private DepartmentService  departmentService;
	
    @RequestMapping("/add")
    @ResponseBody
    public Result<Long> Add(String name){
    	return departmentService.Add(name, 1L);
    }

}

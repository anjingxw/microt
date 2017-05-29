package com.zzh.micro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zzh.micro.dto.FileAttributeDto;
import com.zzh.micro.dto.Result;
import com.zzh.micro.entity.CompanyDepartment;
import com.zzh.micro.entity.FileAttribute;
import com.zzh.micro.entity.TransactionAttribute;
import com.zzh.micro.entity.User;
import com.zzh.micro.repository.FileAttributeReprository;
import com.zzh.micro.repository.MeetingAttributeReprository;
import com.zzh.micro.repository.UserReprository;
import com.zzh.micro.service.FileAttributeService;
import com.zzh.micro.util.DateUtils;

public class FileAttributeServiceImpl implements FileAttributeService{
	@Autowired 
	UserReprository userReprository;  
	@Autowired
	FileAttributeReprository  fileAttributeReprository;


	@Override
	public Page<FileAttributeDto> findAllDto(Pageable pageable) {
		return fileAttributeReprository.findAllDto(pageable);
	}

	@Override
	public Result<Long> Add(String name, Long loginId) {
		User user = userReprository.findByUserID(loginId);
		FileAttribute attribute = new FileAttribute();
		attribute.setCompanyID(user.getCompany().getCompanyID());
		attribute.setFileAttributeName(name);
		attribute.setCreateUserID(user.getUserID());
		attribute.setCreateTime(DateUtils.getCurrentTime());
		fileAttributeReprository.save(attribute);
		return new Result<Long>(true, attribute.getFileAttributeID());
	}

	@Override
	public Result<Boolean> Update(Long id, String name) {
		fileAttributeReprository.modifyById(name, id);
		return new Result<Boolean>(true, true);
	}

	@Override
	public Result<Boolean> Delete(Long id) {
		fileAttributeReprository.deleteById(id);
		return new Result<Boolean>(true, true);
	}

}

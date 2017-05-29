package com.zzh.micro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzh.micro.dto.MeetingAttributeDto;
import com.zzh.micro.dto.Result;
import com.zzh.micro.entity.MeetingAttribute;
import com.zzh.micro.entity.User;
import com.zzh.micro.repository.MeetingAttributeReprository;
import com.zzh.micro.repository.UserReprository;
import com.zzh.micro.service.MeetingAttributeService;
import com.zzh.micro.util.DateUtils;

@Service
public class MeetingAttributeServiceImpl implements MeetingAttributeService {
	
	@Autowired 
	UserReprository userReprository;  
	@Autowired
	MeetingAttributeReprository  meetingAttributeReprository;
	
	public Page<MeetingAttributeDto> findAllDto(Pageable pageable){
		return meetingAttributeReprository.findAllDto(pageable);
	}
	
	public Result<java.util.List<MeetingAttribute>>  List(){
		return new Result<java.util.List<MeetingAttribute>>(true, meetingAttributeReprository.findAll());
	}
	
	@Override
	public Result<Long> Add(String  name, Long loginId) {
		User user = userReprository.findByUserID(loginId);
		MeetingAttribute meetingAttribute = new MeetingAttribute();
		meetingAttribute.setCompanyID(user.getCompany().getCompanyID());
		meetingAttribute.setMeetingAttributeName(name);
		meetingAttribute.setCreateUserID(user.getUserID());
		meetingAttribute.setCreateTime(DateUtils.getCurrentTime());
		meetingAttributeReprository.save(meetingAttribute);
		return new Result<Long>(true, meetingAttribute.getMeetingAttributeID());
	}
	
	public Result<Boolean>  Update(Long departmentId, String  name){
		meetingAttributeReprository.modifyById(name, departmentId);
		return new Result<Boolean>(true, true);
	}
	
	@Transactional
	public Result<Boolean>  Delete(Long departmentId){
		meetingAttributeReprository.deleteById(departmentId);
		return new Result<Boolean>(true, true);
	}

}

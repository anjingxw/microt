package com.zzh.micro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zzh.micro.dto.MeetingAttributeDto;
import com.zzh.micro.dto.Result;
import com.zzh.micro.entity.MeetingAttribute;


public interface MeetingAttributeService {
	public Page<MeetingAttributeDto> findAllDto(Pageable pageable);
	public Result<java.util.List<MeetingAttribute>>  List();
	public Result<Long>  Add(String  name, Long loginId);
	public Result<Boolean>  Update(Long meetingAttributeId, String  name);
	public Result<Boolean>  Delete(Long meetingAttributeId);
}

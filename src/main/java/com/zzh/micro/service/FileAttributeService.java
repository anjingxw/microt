package com.zzh.micro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zzh.micro.dto.FileAttributeDto;
import com.zzh.micro.dto.Result;

public interface FileAttributeService {
	public Page<FileAttributeDto> findAllDto(Pageable pageable);
	public Result<Long>  Add(String  name, Long loginId);
	public Result<Boolean>  Update(Long id, String  name);
	public Result<Boolean>  Delete(Long id);
}

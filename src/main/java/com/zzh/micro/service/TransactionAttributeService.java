package com.zzh.micro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zzh.micro.dto.Result;
import com.zzh.micro.dto.TransactionAttributeDto;

public interface TransactionAttributeService {
	public Page<TransactionAttributeDto> findAllDto(Pageable pageable);
	public Result<Long>  Add(String  name, Long loginId);
	public Result<Boolean>  Update(Long transactionAttributeId, String  name);
	public Result<Boolean>  Delete(Long transactionAttributeId);
}

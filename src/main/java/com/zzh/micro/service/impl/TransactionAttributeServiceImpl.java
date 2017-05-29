package com.zzh.micro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzh.micro.dto.Result;
import com.zzh.micro.dto.TransactionAttributeDto;
import com.zzh.micro.entity.TransactionAttribute;
import com.zzh.micro.entity.User;
import com.zzh.micro.repository.TransactionAttributeRepository;
import com.zzh.micro.repository.UserReprository;
import com.zzh.micro.service.TransactionAttributeService;
import com.zzh.micro.util.DateUtils;

@Service
public class TransactionAttributeServiceImpl implements TransactionAttributeService{
	@Autowired 
	UserReprository userReprository;  
	@Autowired
	TransactionAttributeRepository  transactionAttributeRepository;
	
	public Page<TransactionAttributeDto> findAllDto(Pageable pageable){
		return transactionAttributeRepository.findAllDto(pageable);
	}
	
	@Override
	public Result<Long> Add(String  name, Long loginId) {
		User user = userReprository.findByUserID(loginId);
		TransactionAttribute attribute = new TransactionAttribute();
		attribute.setCompanyID(user.getCompany().getCompanyID());
		attribute.setTransactionAttributeName(name);
		attribute.setCreateUserID(user.getUserID());
		attribute.setCreateTime(DateUtils.getCurrentTime());
		transactionAttributeRepository.save(attribute);
		return new Result<Long>(true, attribute.getTransactionAttributeID());
	}
	
	public Result<Boolean>  Update(Long id, String  name){
		transactionAttributeRepository.modifyById(name, id);
		return new Result<Boolean>(true, true);
	}
	
	@Transactional
	public Result<Boolean>  Delete(Long id){
		transactionAttributeRepository.deleteById(id);
		return new Result<Boolean>(true, true);
	}
}

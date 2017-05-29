package com.zzh.micro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.zzh.micro.dto.TransactionAttributeDto;
import com.zzh.micro.entity.TransactionAttribute;

public interface TransactionAttributeRepository  extends JpaRepository<TransactionAttribute, Long> {
	public String findSql = "select new com.zzh.micro.dto.TransactionAttributeDto(d.transactionAttributeID, d.transactionAttributeName, d.createTime, up.displayName) from TransactionAttribute d, User u, UserProperty up where d.createUserID = u.userID and u.property = up.userPropertyID";
	
	@Query(findSql)
	Page<TransactionAttributeDto> findAllDto(Pageable pageable);
	
	@Transactional
	@Modifying
	@Query("delete from TransactionAttribute where transactionAttributeID = ?1")
	int deleteById(Long meetingAttributeID);
	
	@Modifying
	@Transactional
	@Query("update TransactionAttribute u set u.transactionAttributeName = ?1 where u.transactionAttributeID = ?2")
	int modifyById(String  meetingAttributeName, Long meetingAttributeID);
}

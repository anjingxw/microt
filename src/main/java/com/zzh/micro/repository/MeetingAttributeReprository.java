package com.zzh.micro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.zzh.micro.dto.MeetingAttributeDto;
import com.zzh.micro.entity.MeetingAttribute;

public interface MeetingAttributeReprository extends JpaRepository<MeetingAttribute, Long>{
	public String findSql = "select new com.zzh.micro.dto.MeetingAttributeDto(d.meetingAttributeID, d.meetingAttributeName, d.createTime, up.displayName) from MeetingAttribute d, User u, UserProperty up where d.createUserID = u.userID and u.property = up.userPropertyID";
	
	@Query(findSql)
	Page<MeetingAttributeDto> findAllDto(Pageable pageable);
	
	@Transactional
	@Modifying
	@Query("delete from MeetingAttribute where meetingAttributeID = ?1")
	int deleteById(Long meetingAttributeID);
	
	@Modifying
	@Transactional
	@Query("update MeetingAttribute u set u.meetingAttributeName = ?1 where u.meetingAttributeID = ?2")
	int modifyById(String  meetingAttributeName, Long meetingAttributeID);
	
	
}

package com.zzh.micro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.zzh.micro.dto.FileAttributeDto;
import com.zzh.micro.entity.FileAttribute;

public interface FileAttributeReprository extends JpaRepository<FileAttribute, Long> {
	public String findSql = "select new com.zzh.micro.dto.FileAttributeDto(d.fileAttributeID, d.fileAttributeName, d.createTime, up.displayName) from FileAttribute d, User u, UserProperty up where d.createUserID = u.userID and u.property = up.userPropertyID";
	
	@Query(findSql)
	Page<FileAttributeDto> findAllDto(Pageable pageable);
	
	@Transactional
	@Modifying
	@Query("delete from FileAttribute where fileAttributeID = ?1")
	int deleteById(Long meetingAttributeID);
	
	@Modifying
	@Transactional
	@Query("update FileAttribute u set u.fileAttributeName = ?1 where u.fileAttributeID = ?2")
	int modifyById(String  meetingAttributeName, Long meetingAttributeID);
	
}

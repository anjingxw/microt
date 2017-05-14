package com.zzh.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzh.micro.entity.User;
public interface  UserReprository extends JpaRepository<User, Long>{
	User findByUserID(Long id);
	User findByLoginName(String loginName);
}

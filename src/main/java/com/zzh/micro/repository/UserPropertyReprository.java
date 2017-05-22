package com.zzh.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzh.micro.entity.UserProperty;

public interface UserPropertyReprository  extends JpaRepository<UserProperty, Long>{

}

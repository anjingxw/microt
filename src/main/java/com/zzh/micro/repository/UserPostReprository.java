package com.zzh.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzh.micro.entity.UserPost;

public interface UserPostReprository  extends JpaRepository<UserPost, Long> {

}

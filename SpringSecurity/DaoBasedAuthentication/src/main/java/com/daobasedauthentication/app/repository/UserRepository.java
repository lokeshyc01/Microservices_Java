package com.daobasedauthentication.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daobasedauthentication.app.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	public UserEntity findByName(String username);
}

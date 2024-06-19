package com.graphql.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.app.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}

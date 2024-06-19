package com.graphql.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.app.pojo.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

}

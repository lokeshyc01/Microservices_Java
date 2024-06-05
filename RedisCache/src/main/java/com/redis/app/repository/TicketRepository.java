package com.redis.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<com.redis.app.entity.Ticket, Long>{

}

package com.caching.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caching.app.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}

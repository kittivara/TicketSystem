package com.example.ticketsystem.Repository;

import com.example.ticketsystem.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long>
{
    Ticket findAllById(Long id);
}

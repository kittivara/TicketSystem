package com.example.ticketsystem.Service;

import com.example.ticketsystem.Model.Ticket;
import com.example.ticketsystem.Repository.TicketRepository;
import com.example.ticketsystem.Utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private TicketRepository ticketRepository;
    private final Util util = new Util();
    private String reqStatus;
    private String dateToString;

    @Autowired
    public TicketService(TicketRepository ticketRepository) { this.ticketRepository = ticketRepository; }

    public List<Ticket> getTicketList()
    {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) { return ticketRepository.findAllById(id); }

    public Ticket createTicket(Ticket ticket)
    {
        this.reqStatus = util.changeUpperCaseStatus(ticket.getStatus());
        ticket.setStatus(this.reqStatus);
        return ticketRepository.save(ticket);
    }

    public Ticket changeStatus(Long id,Ticket ticketReq)
    {
        this.reqStatus = util.changeUpperCaseStatus(ticketReq.getStatus());
        ticketReq.setStatus(this.reqStatus);
        return ticketRepository.findAllById(id) != null ?
                ticketRepository.save(ticketReq) : null;
    }

    public Page<Ticket> findTicketByPaginated (int page , int size)
    {
        Page<Ticket> pageTicket = ticketRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "status")));
        return pageTicket;
    }
}
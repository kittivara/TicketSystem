package com.example.ticketsystem.Controller;

import com.example.ticketsystem.Model.Ticket;
import com.example.ticketsystem.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/ticket")
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/list")
    public List<Ticket> ticketList()
    {
        return ticketService.getTicketList();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTicketById(@PathVariable Long id) {
        Ticket ticket = ticketService.getTicketById(id);
        if (ticket != null) {
            return ResponseEntity.ok(ticket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createTicket(@RequestBody Ticket body) {
        Ticket ticket = ticketService.createTicket(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> changeStatusTicket(@PathVariable Long id, @RequestBody Ticket body)
    {
        body.setId(id);
        Ticket ticket = ticketService.changeStatus(id,body);
        return ticket != null ? ResponseEntity.ok(ticket)
                :ResponseEntity.notFound().build();
    }



}
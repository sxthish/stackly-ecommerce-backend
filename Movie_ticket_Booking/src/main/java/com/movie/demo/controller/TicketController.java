package com.movie.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.demo.model.Ticket;

import com.movie.demo.service.TicketService;

import jakarta.validation.Valid;

@RestController
@Validated
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() 
    {
        return ticketService.getAllTickets();
    }

    @GetMapping("/tickets/{id}")
    public Ticket getTicketById(@PathVariable int id) 
    {
        return ticketService.getTicketById(id);
    }

    @PostMapping("/tickets")
    public Ticket addTicket(@Valid @RequestBody Ticket ticket) 
    {
        return ticketService.addTicket(ticket);
    }


    @PutMapping("/tickets/{id}")
    public String updateTicket(@PathVariable int id, @Valid @RequestBody Ticket ticket) 
    {
        return ticketService.updateTicket(id,ticket);
    }

    @DeleteMapping("/tickets/{id}")
    public String deleteTicket(@PathVariable int id) 
    {
        return ticketService.deleteTicket(id);
    }
}
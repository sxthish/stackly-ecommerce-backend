package com.movie.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.demo.model.Ticket;

@Service
public class TicketService {

    List<Ticket> ticketList =
            new ArrayList<>(Arrays.asList(
                    new Ticket(101,"Leo","Sathish","A1",250.0,"BOOKED",true,"PREMIUM"),
                    new Ticket(102,"Jailer","Sai","C3",120.0,"BOOKED",false,"BUDGET")));

    public List<Ticket> getAllTickets() {
        return ticketList;
    }

    public Ticket getTicketById(int id) 
    {
        for (Ticket t : ticketList) 
        {
            if (t.getTicketId() == id) 
            {
                return t;
            }
        }
        return null;
    }

    public Ticket addTicket(Ticket ticket) 
    {
        for (Ticket t : ticketList) 
        {
            if (t.getSeatNumber().equalsIgnoreCase(ticket.getSeatNumber())) 
            {
                throw new RuntimeException("Seat already booked");
            }
        }

        ticket.setBookingStatus("BOOKED");


        if (ticket.getSeatNumber().startsWith("A")) 
        {
            ticket.setPremiumSeat(true);
        } else 
        {
            ticket.setPremiumSeat(false);
        }

        if (ticket.getTicketPrice() >= 200) 
        {
            ticket.setPriceCategory("PREMIUM");
        }
        else 
        {
            ticket.setPriceCategory("BUDGET");
        }
        ticketList.add(ticket);
        return ticket;
    }


    public String updateTicket(int id,Ticket ticket) 
    {
        for (Ticket t : ticketList) 
        {
            if (t.getTicketId() == id) 
            {
                t.setMovieName(ticket.getMovieName());
                t.setCustomerName(ticket.getCustomerName());
                t.setSeatNumber(ticket.getSeatNumber());
                t.setTicketPrice(ticket.getTicketPrice());

                return "Ticket Updated Successfully";
            }
        }
        return "Ticket Not Found";
    }

    public String deleteTicket(int id) 
    {
        for (Ticket t : ticketList) 
        {
            if (t.getTicketId() == id) 
            {
                ticketList.remove(t);
                return "Ticket Deleted Successfully";
            }
        }
        return "Ticket Not Found";
    }
}
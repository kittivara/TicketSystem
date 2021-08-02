package com.example.ticketsystem.Support;

import com.example.ticketsystem.Model.Ticket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TicketSupportTest {
    public static List<Ticket> getTicketList() throws ParseException {


//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = formatter.parse("2021-07-21");

//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//
//        String dateInString = "2021-07-21";
//        Date date = formatter.parse(dateInString);



        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date = formatter.parse("2021-07-21");


        List<Ticket> ticketList = new ArrayList<>();

        Ticket ticket = new Ticket();
        ticket.setId(1L);
        ticket.setTitle("Ticket.A");
        ticket.setDescription("Test A");
        ticket.setContract("1234/45");
        ticket.setStatus("Accepted");
        ticket.setCreateTimestamp(date);
        ticket.setLatestUpdateTimestamp(date);
        ticketList.add(ticket);

        ticket = new Ticket();
        ticket.setId(2L);
        ticket.setTitle("Ticket.B");
        ticket.setDescription("Test B");
        ticket.setContract("2345/54");
        ticket.setStatus("Pending");
        ticket.setCreateTimestamp(date);
        ticket.setLatestUpdateTimestamp(date);
        ticketList.add(ticket);

        ticket = new Ticket();
        ticket.setId(3L);
        ticket.setTitle("Ticket.C");
        ticket.setDescription("Test C");
        ticket.setContract("1234/45");
        ticket.setStatus("Rejected");
        ticket.setCreateTimestamp(date);
        ticket.setLatestUpdateTimestamp(date);
        ticketList.add(ticket);

        ticket = new Ticket();
        ticket.setId(4L);
        ticket.setTitle("Ticket.C");
        ticket.setDescription("Test C");
        ticket.setContract("1234/45");
        ticket.setStatus("Resolved");
        ticket.setCreateTimestamp(date);
        ticket.setLatestUpdateTimestamp(date);
        ticketList.add(ticket);

        return ticketList;

    }
}

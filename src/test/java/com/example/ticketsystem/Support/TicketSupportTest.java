package com.example.ticketsystem.Support;

import com.example.ticketsystem.Model.Ticket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TicketSupportTest {
    public static List<Ticket> getTicketList() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setCalendar(new GregorianCalendar());
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+7"));

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
        ticket.setTitle("Ticket.D");
        ticket.setDescription("Test D");
        ticket.setContract("1234/45");
        ticket.setStatus("Resolved");
        ticket.setCreateTimestamp(date);
        ticket.setLatestUpdateTimestamp(date);
        ticketList.add(ticket);

        return ticketList;

    }

    public static Ticket getOldTicket() throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date = formatter.parse("2021-07-21");

        Ticket ticketReq = new Ticket();
        ticketReq.setId(2L);
        ticketReq.setTitle("Ticket.A");
        ticketReq.setDescription("Test A");
        ticketReq.setContract("1234/45");
        ticketReq.setStatus("Accepted");
        ticketReq.setCreateTimestamp(date);
        ticketReq.setLatestUpdateTimestamp(date);


        return ticketReq;

    }

    public static Ticket getNewTicket() throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date = formatter.parse("2021-07-21");


        Ticket ticketReq = new Ticket();
        ticketReq.setId(2L);
        ticketReq.setTitle("Ticket.A");
        ticketReq.setDescription("Test A");
        ticketReq.setContract("1234/45");
        ticketReq.setStatus("Pending");
        ticketReq.setCreateTimestamp(date);
        ticketReq.setLatestUpdateTimestamp(date);


        return ticketReq;

    }



}

package com.example.ticketsystem.Controller;

import com.example.ticketsystem.Service.TicketService;
import com.example.ticketsystem.Support.TicketSupportTest;
import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TicketControllerTest {

    @Mock
    private TicketService tickerService;

    @InjectMocks
    TicketController ticketController;

    private static final String urlTicket = "/ticket/";
    private static final String urlTicketList = "/ticket/list";

    private MockMvc mvc;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        ticketController = new TicketController((tickerService));
        mvc = MockMvcBuilders.standaloneSetup(ticketController).build();
    }

    @Test
    void testGetTicketList() throws Exception
    {
        when(tickerService.getTicketList())
                .thenReturn(TicketSupportTest.getTicketList());

        MvcResult mvcResult = mvc.perform(get(urlTicketList))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date = formatter.parse("2021-07-21");


        JSONArray jsonArray = new JSONArray(mvcResult.getResponse().getContentAsString());
        assertEquals("1",jsonArray.getJSONObject(0).get("id").toString());
        assertEquals("Ticket.A",jsonArray.getJSONObject(0).get("title").toString());
        assertEquals("Test A",jsonArray.getJSONObject(0).get("description").toString());
        assertEquals("1234/45",jsonArray.getJSONObject(0).get("contract").toString());
        assertEquals("Accepted",jsonArray.getJSONObject(0).get("status").toString());
        assertEquals(date,jsonArray.getJSONObject(0).get("createTimestamp"));
        assertEquals(date,jsonArray.getJSONObject(0).get("latestUpdateTimestamp"));

        assertEquals("2",jsonArray.getJSONObject(1).get("id").toString());
        assertEquals("Ticket.B",jsonArray.getJSONObject(1).get("title").toString());
        assertEquals("Test B",jsonArray.getJSONObject(1).get("description").toString());
        assertEquals("1234/45",jsonArray.getJSONObject(1).get("contract").toString());
        assertEquals("Pending",jsonArray.getJSONObject(1).get("status").toString());
        assertEquals(date,jsonArray.getJSONObject(1).get("createTimestamp"));
        assertEquals(date,jsonArray.getJSONObject(1).get("latestUpdateTimestamp"));

        assertEquals("1",jsonArray.getJSONObject(2).get("id").toString());
        assertEquals("Ticket.C",jsonArray.getJSONObject(2).get("title").toString());
        assertEquals("Test C",jsonArray.getJSONObject(2).get("description").toString());
        assertEquals("1234/45",jsonArray.getJSONObject(2).get("contract").toString());
        assertEquals("Rejected",jsonArray.getJSONObject(2).get("status").toString());
        assertEquals(date,jsonArray.getJSONObject(2).get("createTimestamp"));
        assertEquals(date,jsonArray.getJSONObject(2).get("latestUpdateTimestamp"));

        assertEquals("1",jsonArray.getJSONObject(3).get("id").toString());
        assertEquals("Ticket.D",jsonArray.getJSONObject(3).get("title").toString());
        assertEquals("Test D",jsonArray.getJSONObject(3).get("description").toString());
        assertEquals("1234/45",jsonArray.getJSONObject(3).get("contract").toString());
        assertEquals("Resolved",jsonArray.getJSONObject(3).get("status").toString());
        assertEquals(date,jsonArray.getJSONObject(3).get("createTimestamp"));
        assertEquals(date,jsonArray.getJSONObject(3).get("latestUpdateTimestamp"));


    }
}

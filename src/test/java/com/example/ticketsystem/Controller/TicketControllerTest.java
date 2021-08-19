package com.example.ticketsystem.Controller;

import com.example.ticketsystem.Model.Ticket;
import com.example.ticketsystem.Service.TicketService;
import com.example.ticketsystem.Support.TicketSupportTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONArray;
import org.json.JSONObject;
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

//    @Test
//    void testGetTicketList() throws Exception
//    {
//        when(tickerService.getTickets())
//                .thenReturn(TicketSupportTest.getTickets());
//
//        MvcResult mvcResult = mvc.perform(get(urlTicketList))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//
//        JSONArray jsonArray = new JSONArray(mvcResult.getResponse().getContentAsString());
//        assertEquals("1",jsonArray.getJSONObject(0).get("id").toString());
//        assertEquals("Ticket.A",jsonArray.getJSONObject(0).get("title").toString());
//        assertEquals("Test A",jsonArray.getJSONObject(0).get("description").toString());
//        assertEquals("1234/45",jsonArray.getJSONObject(0).get("contract").toString());
//        assertEquals("Accepted",jsonArray.getJSONObject(0).get("status").toString());
//        assertEquals("2021-07-20",jsonArray.getJSONObject(0).get("createTimestamp"));
//        assertEquals("2021-07-20",jsonArray.getJSONObject(0).get("latestUpdateTimestamp"));
//
//        assertEquals("2",jsonArray.getJSONObject(1).get("id").toString());
//        assertEquals("Ticket.B",jsonArray.getJSONObject(1).get("title").toString());
//        assertEquals("Test B",jsonArray.getJSONObject(1).get("description").toString());
//        assertEquals("2345/54",jsonArray.getJSONObject(1).get("contract").toString());
//        assertEquals("Pending",jsonArray.getJSONObject(1).get("status").toString());
//        assertEquals("2021-07-20",jsonArray.getJSONObject(1).get("createTimestamp"));
//        assertEquals("2021-07-20",jsonArray.getJSONObject(1).get("latestUpdateTimestamp"));
//
//        assertEquals("3",jsonArray.getJSONObject(2).get("id").toString());
//        assertEquals("Ticket.C",jsonArray.getJSONObject(2).get("title").toString());
//        assertEquals("Test C",jsonArray.getJSONObject(2).get("description").toString());
//        assertEquals("1234/45",jsonArray.getJSONObject(2).get("contract").toString());
//        assertEquals("Rejected",jsonArray.getJSONObject(2).get("status").toString());
//        assertEquals("2021-07-20",jsonArray.getJSONObject(2).get("createTimestamp"));
//        assertEquals("2021-07-20",jsonArray.getJSONObject(2).get("latestUpdateTimestamp"));
//
//        assertEquals("4",jsonArray.getJSONObject(3).get("id").toString());
//        assertEquals("Ticket.D",jsonArray.getJSONObject(3).get("title").toString());
//        assertEquals("Test D",jsonArray.getJSONObject(3).get("description").toString());
//        assertEquals("1234/45",jsonArray.getJSONObject(3).get("contract").toString());
//        assertEquals("Resolved",jsonArray.getJSONObject(3).get("status").toString());
//        assertEquals("2021-07-20",jsonArray.getJSONObject(3).get("createTimestamp"));
//        assertEquals("2021-07-20",jsonArray.getJSONObject(3).get("latestUpdateTimestamp"));
//
//
//    }

//    @Test
//    void testChangeStatusTicket() throws Exception
//    {
//        Ticket reqTicket = TicketSupportTest.getOldTicket();
//        Long reqId = 2L;
//
//        String status = "Pending";
//
//        reqTicket.setStatus(status);
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
//        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//        String requestJson = ow.writeValueAsString(reqTicket);
//
//        when(tickerService.changeStatus(reqId, reqTicket))
//                .thenReturn(TicketSupportTest.getNewTicket());
//
//        MvcResult mvcResult = mvc.perform(put(urlTicket+""+reqId)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(requestJson))
//                .andExpect(status().isOk())
//                .andReturn();
//
//
//        JSONObject jsonObject = new JSONObject(mvcResult.getResponse().getContentAsString());
//        assertEquals("2",jsonObject.get("id").toString());
//        assertEquals("Ticket.A",jsonObject.get("title"));
//        assertEquals("Test A",jsonObject.get("description"));
//        assertEquals("1234/45",jsonObject.get("contract"));
//        assertEquals(status,jsonObject.get("status"));
//        assertEquals("2021-07-20",jsonObject.get("createTimestamp"));
//        assertEquals("2021-07-20",jsonObject.get("latestUpdateTimestamp"));
//
//
//    }
}

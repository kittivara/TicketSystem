package com.example.ticketsystem.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;

    private String description;

    private String contract;

    private String status;


    @JsonFormat(pattern="yyyy-MM-dd")
    private Date  createTimestamp;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date  latestUpdateTimestamp;

}



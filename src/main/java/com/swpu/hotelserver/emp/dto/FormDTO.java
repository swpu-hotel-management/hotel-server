package com.swpu.hotelserver.emp.dto;

import com.swpu.hotelserver.emp.entity.Client;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FormDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Client> clients;
    private String roomNum;
}

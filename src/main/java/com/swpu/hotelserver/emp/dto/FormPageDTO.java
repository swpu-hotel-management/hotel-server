package com.swpu.hotelserver.emp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FormPageDTO {
    private Long pageNumber;
    private Long pageSize;
    private String roomNum;
    private String type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}

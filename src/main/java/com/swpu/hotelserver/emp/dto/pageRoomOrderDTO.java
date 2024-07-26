package com.swpu.hotelserver.emp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class pageRoomOrderDTO {
    private Integer id;
    private Integer roomId;
    private String clientName;
    private String orderNum;
    private LocalDateTime createTime;
    private Integer price;
}

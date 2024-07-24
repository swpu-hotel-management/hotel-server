package com.swpu.hotelserver.emp.dto;

import lombok.Data;

@Data
public class AddOrderDTO {
    private Integer id;
    private Integer roomId;
    private Integer clientId;
    private String orderNum;
}

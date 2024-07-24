package com.swpu.hotelserver.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPageDTO {
    private String orderNum;
    private int page;
    private int pageSize;
}

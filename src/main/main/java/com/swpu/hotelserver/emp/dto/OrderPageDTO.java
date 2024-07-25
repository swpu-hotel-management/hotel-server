package com.swpu.hotelserver.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPageDTO {
    private String orderNum;
    private int page;
    private int pageSize;
    private String clientName;
    private Date createTime;
}

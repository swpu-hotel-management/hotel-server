package com.swpu.hotelserver.emp.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DataTurnoverPair {
    private LocalDate date;
    private Integer turnover;
}

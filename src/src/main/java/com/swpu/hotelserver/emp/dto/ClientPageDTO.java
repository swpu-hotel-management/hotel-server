package com.swpu.hotelserver.emp.dto;

import lombok.Data;

@Data
public class ClientPageDTO {
    private Integer pageNumber;
    private Integer pageSize;
    private String name;
    private String idNum;
    private String sex;
    private Integer age;
    private String address;
}

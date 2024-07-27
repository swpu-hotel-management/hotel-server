package com.swpu.hotelserver.emp.dto;

import lombok.Data;

@Data
public class QuseryPageEmp {
    private Long pageNumber;
    private Long pageSize;
    //条件查询
    private String username;
    private String name;
    private String sex;
}

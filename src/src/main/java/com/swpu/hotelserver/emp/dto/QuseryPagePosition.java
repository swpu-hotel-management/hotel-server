package com.swpu.hotelserver.emp.dto;

import lombok.Data;

@Data
public class QuseryPagePosition {
    private Long pageNumber;
    private Long pageSize;
    private String roleName;
    private Integer permType;
}

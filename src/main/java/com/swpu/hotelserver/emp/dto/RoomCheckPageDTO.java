package com.swpu.hotelserver.emp.dto;

import lombok.Data;
@Data
public class RoomCheckPageDTO {
        private Long pageNumber;
        private Long pageSize;
        private String roomNum;
        private String type;
        private Integer status;
}

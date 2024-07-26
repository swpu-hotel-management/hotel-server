package com.swpu.hotelserver.emp.dto;

public class DeleteRoomRequest {
    private Integer roomNum;

    // 构造函数、getter 和 setter
    public DeleteRoomRequest() {}

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }
}

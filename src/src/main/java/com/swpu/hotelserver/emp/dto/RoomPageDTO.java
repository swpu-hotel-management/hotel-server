package com.swpu.hotelserver.emp.dto;

public class RoomPageDTO {
    private int current; // 当前页码
    private int size; // 每页大小

    public RoomPageDTO(int current, int size) {
        this.current = current;
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

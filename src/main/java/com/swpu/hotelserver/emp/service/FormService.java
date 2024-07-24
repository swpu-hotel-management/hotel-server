package com.swpu.hotelserver.emp.service;


import com.swpu.hotelserver.emp.dto.FormDTO;

public interface FormService {
    boolean checkIn(FormDTO formDTO);

    void checkOut(Integer id);

    void reIn(Integer id,Long hours);
}

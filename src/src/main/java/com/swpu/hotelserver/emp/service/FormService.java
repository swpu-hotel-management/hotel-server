package com.swpu.hotelserver.emp.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.hotelserver.emp.dto.FormDTO;
import com.swpu.hotelserver.emp.dto.FormPageDTO;
import com.swpu.hotelserver.emp.entity.Form;
import com.swpu.hotelserver.emp.entity.Room;

public interface FormService extends IService<Form> {
    boolean checkIn(FormDTO formDTO);

    void checkOut(Integer id);

    void reIn(Integer id,Long hours);

    Page<Form> getFormPage(FormPageDTO formPageDTO);
}

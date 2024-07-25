package com.swpu.hotelserver.emp.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swpu.hotelserver.emp.dto.FormDTO;
import com.swpu.hotelserver.emp.dto.FormPageDTO;
import com.swpu.hotelserver.emp.entity.Client;
import com.swpu.hotelserver.emp.entity.Form;
import com.swpu.hotelserver.emp.mapper.ClientMapper;
import com.swpu.hotelserver.emp.mapper.FormMapper;
import com.swpu.hotelserver.emp.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FormServiceImpl extends ServiceImpl<FormMapper, Form> implements FormService {
    @Autowired
    private FormMapper formMapper;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public boolean checkIn(FormDTO formDTO) {
        Form form = new Form();
        form.setStartTime(formDTO.getStartTime());
        form.setEndTime(formDTO.getEndTime());
        form.setRoomNum(formDTO.getRoomNum());
        List<Client> clients = formDTO.getClients();
        int status = formMapper.getRoomStatus(formDTO.getRoomNum());
        if (status == 2 || status == -1) {
            return false;
        }
        for (Client client : clients) {
            if (client != null) {
                clientMapper.insert(client);
            }
        }
        for (int i = 0; i < clients.size(); i++) {
            switch (i) {
                case 0:
                    form.setClient1Name(clients.get(0).getName());
                    break;
                case 1:
                    form.setClient2Name(clients.get(1).getName());
                    break;
                case 2:
                    form.setClient3Name(clients.get(2).getName());
                    break;
                case 3:
                    form.setClient4Name(clients.get(3).getName());
                    break;
                default:
                    break;
            }
        }
        int num = formMapper.insert(form);
        if (num > 0) {
            formMapper.setStatus(formDTO.getRoomNum());
            return true;
        }
        return false;
    }

    @Override
    public void checkOut(Integer id) {
        formMapper.checkOut(id);
    }

    @Override
    public void reIn(Integer id,Long hours) {
        LocalDateTime originEndTime = formMapper.getEndTime(id);
        LocalDateTime endTime = originEndTime.plusHours(hours);
        formMapper.reIn(id,endTime);
    }

    @Override
    public Page<Form> getFormPage(FormPageDTO formPageDTO) {
        Page<Form> page = new Page<>(formPageDTO.getPageNumber(), formPageDTO.getPageSize());
        QueryWrapper<Form> w = new QueryWrapper<>();
        w.like(formPageDTO.getRoomNum()!=null, "roomNum", formPageDTO.getRoomNum())
                .like(formPageDTO.getType()!=null, "type", formPageDTO.getType())
                .ge("start_time", formPageDTO.getStartTime())
                .le("end_time", formPageDTO.getEndTime());
        this.page(page,w);
        return page;
    }
}

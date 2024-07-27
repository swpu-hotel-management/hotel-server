package com.swpu.hotelserver.emp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swpu.hotelserver.emp.dto.ClientPageDTO;
import com.swpu.hotelserver.emp.entity.Client;
import com.swpu.hotelserver.emp.entity.Form;
import com.swpu.hotelserver.emp.mapper.ClientMapper;
import com.swpu.hotelserver.emp.mapper.FormMapper;
import com.swpu.hotelserver.emp.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {
    @Override
    public Page<Client> getPageClient(ClientPageDTO clientPageDTO) {
        Page<Client> page = new Page<>();
        QueryWrapper<Client> w = new QueryWrapper<>();
        w.like(clientPageDTO.getName()!=null,"name",clientPageDTO.getName())
                .like(clientPageDTO.getIdNum()!=null, "id_num",clientPageDTO.getIdNum())
                .like(clientPageDTO.getSex()!=null,"sex",clientPageDTO.getSex())
                .like(clientPageDTO.getAge()!=null,"age",clientPageDTO.getAge())
                .like(clientPageDTO.getAddress()!=null,"address",clientPageDTO.getAddress())
                .orderByAsc("id");
        this.page(page, w);
        return page;
    }
}

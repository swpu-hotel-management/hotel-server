package com.swpu.hotelserver.emp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.hotelserver.emp.dto.ClientPageDTO;
import com.swpu.hotelserver.emp.entity.Client;
import com.swpu.hotelserver.emp.entity.Form;

public interface ClientService extends IService<Client> {
    Page<Client> getPageClient(ClientPageDTO clientPageDTO);
}

package com.swpu.hotelserver.emp.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.hotelserver.common.result.Result;
import com.swpu.hotelserver.emp.dto.ClientPageDTO;
import com.swpu.hotelserver.emp.entity.Client;
import com.swpu.hotelserver.emp.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/page")
    public Result<?> page(ClientPageDTO clientPageDTO) {
        log.info("客人分页查询: {}", clientPageDTO);
        Page<Client> page = clientService.getPageClient(clientPageDTO);
        JSONObject obj = new JSONObject();
        obj.put("total", page.getTotal());
        obj.put("rows", page.getRecords());
        return new Result<>().success().put(obj);
    }
}

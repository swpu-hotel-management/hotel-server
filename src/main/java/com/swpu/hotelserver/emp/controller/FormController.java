package com.swpu.hotelserver.emp.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.hotelserver.common.result.Result;
import com.swpu.hotelserver.emp.dto.FormDTO;
import com.swpu.hotelserver.emp.dto.FormPageDTO;
import com.swpu.hotelserver.emp.entity.Form;
import com.swpu.hotelserver.emp.entity.Room;
import com.swpu.hotelserver.emp.service.FormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form")
@Slf4j
public class FormController {
    @Autowired
    private FormService formService;
    @PostMapping("/add")
    public Result<?> checkIn(@RequestBody FormDTO formDTO){
        log.info("登记入住：form:{}", formDTO);
        boolean b = formService.checkIn(formDTO);
        return b?new Result<>().success("登记成功"):new Result<>().error("登记失败,房间无法使用");
    }
    @PutMapping("/status")
    public Result<?> checkOut(Integer id){
        log.info("退房操作，房间id:{}", id);
        formService.checkOut(id);
        return new Result<>().success("退房成功");
    }
    @PutMapping("/addTime")
    public Result<?> addTime(Integer id, Long hours){
        log.info("续住操作，入住登记表id:{},续住时间hours:{}",id,hours);
        formService.reIn(id,hours);
        return new Result<>().success("续住成功");
    }
    @GetMapping("/page")
    public Result<?> page(FormPageDTO formPageDTO){
        log.info("房间入住查询:{}", formPageDTO);
        Page<Form> page = formService.getFormPage(formPageDTO);
        JSONObject obj = new JSONObject();
        obj.put("total", page.getTotal());
        obj.put("rows", page.getRecords());
        return new Result<>().success().put(obj);
    }

}

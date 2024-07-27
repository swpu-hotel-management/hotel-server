package com.swpu.hotelserver.emp.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.hotelserver.common.result.Result;
import com.swpu.hotelserver.emp.dto.RoomCheckPageDTO;
import com.swpu.hotelserver.emp.entity.Form;
import com.swpu.hotelserver.emp.entity.Room;
import com.swpu.hotelserver.emp.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huchengbo
 * @since 2024-07-24
 */
@RestController
@RequestMapping("/room")
@Slf4j
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping("/checkPage")
    public Result<?> checkPage(RoomCheckPageDTO roomCheckPageDTO) {
      log.info("房间入住登记分页查询:{}",roomCheckPageDTO);
      Page<Room> page = roomService.getRoomCheckPage(roomCheckPageDTO);
      JSONObject obj = new JSONObject();
      obj.put("total", page.getTotal());
      obj.put("rows", page.getRecords());
      return new Result<>().success().put(obj);
    }
}

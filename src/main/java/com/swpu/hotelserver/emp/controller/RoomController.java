package com.swpu.hotelserver.emp.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.hotelserver.common.result.Result;
import com.swpu.hotelserver.emp.dto.DeleteRoomRequest;
import com.swpu.hotelserver.emp.dto.RoomPageDTO;
import com.swpu.hotelserver.emp.dto.RoomCheckPageDTO;
import com.swpu.hotelserver.emp.entity.Form;
import com.swpu.hotelserver.emp.entity.Room;
import com.swpu.hotelserver.emp.service.RoomService;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import org.springframework.web.bind.annotation.*;

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
    /**
     * 获取所有房间信息
     * @return 房间信息列表
     */
    @GetMapping("/list")
    public List<Room> listAllRooms() {
        return roomService.listAllRooms();
    }

    @GetMapping("/select")
    public Room getRoomById(@RequestParam("roomNum") Integer roomNum) {
        return roomService.getRoomById(roomNum);
    }

    @GetMapping("/selectByType")
    public List<Room> getRoomByType(@RequestParam("type") String type){return (List<Room>) roomService.getRoomByType(type);}
    @GetMapping("/selectByStatus")
    public List<Room> getRoomByStatus(@RequestParam("status") Integer status){return (List<Room>) roomService.getRoomByStatus(status);}

    @PostMapping("/add")
    public boolean addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @PostMapping("/delete")
    public boolean deleteRoom(@RequestBody DeleteRoomRequest request) {
        Integer roomNum = request.getRoomNum();
        try {
            Room room = roomService.getRoomById(roomNum);
            if (room.getStatus() != 1) {
                // 如果房间状态不是1（即不可用），则不允许删除
                return false;
            }
            return roomService.deleteRoom(roomNum);
        } catch (Exception e) {
            // 如果发生异常，则视为删除失败
            return false;
        }
    }

    @PutMapping("/update")
    public boolean updateRoom(@RequestBody Room room){return roomService.updateRoom(room);}

    @GetMapping("/page")
    public Result<?> page(
            @RequestParam(value = "current", defaultValue = "1") int current,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(required = false) String roomNum,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Integer status) {

        Page<Room> page = new Page<>(current, size);

        // 如果需要根据房间号、类型或状态进行过滤
        Room roomFilter = new Room();
        if (StringUtils.isNotBlank(roomNum)) {
            roomFilter.setRoomNum(roomNum);
        }
        if (StringUtils.isNotBlank(type)) {
            roomFilter.setType(type);
        }
        if (status != null) {
            roomFilter.setStatus(status);
        }

        Page<Room> roomPage = roomService.pageQuery(page, roomFilter);

        JSONObject obj = new JSONObject();
        obj.put("total", roomPage.getTotal());
        obj.put("rows", roomPage.getRecords());

        return new Result<>().success().put(obj);
    }

    @DeleteMapping("/delete")
    public boolean deleteRoom(Integer roomNum){return roomService.deleteRoom(roomNum);}
}

package com.swpu.hotelserver.emp.controller;

import com.swpu.hotelserver.common.result.Result;
import com.swpu.hotelserver.emp.entity.Room;
import com.swpu.hotelserver.emp.service.RoomService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static net.sf.jsqlparser.parser.feature.Feature.select;

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
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * 获取所有房间信息
     * @return 房间信息列表
     */
    @GetMapping("/list")
    public List<Room> listAllRooms() {
        return roomService.listAllRooms();
    }

    @GetMapping("/select")
    public Room getRoomById(Integer roomNum){
        return roomService.getRoomById(roomNum);
    }

    @PostMapping("/add")
    public boolean addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @DeleteMapping("/delete")
    public boolean deleteRoom(Integer roomNum){return roomService.deleteRoom(roomNum);}
}
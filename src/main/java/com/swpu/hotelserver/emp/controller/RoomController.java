package com.swpu.hotelserver.emp.controller;

import com.swpu.hotelserver.common.result.Result;
import com.swpu.hotelserver.emp.dto.DeleteRoomRequest;
import com.swpu.hotelserver.emp.entity.Room;
import com.swpu.hotelserver.emp.service.RoomService;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    public Room getRoomById(@RequestParam("roomNum") Integer roomNum) {
        return roomService.getRoomById(roomNum);
    }

    @GetMapping("/selectByType")
    public List<Room> getRoomByType(@RequestParam("type") String type){return (List<Room>) roomService.getRoomByType(type);}

    @PostMapping("/add")
    public boolean addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @PostMapping("/delete")
    public boolean deleteRoom(@RequestBody DeleteRoomRequest request) {
        return roomService.deleteRoom(request.getRoomNum());
    }

    @PutMapping("/update")
    public boolean updateRoom(@RequestBody Room room){return roomService.updateRoom(room);}
}
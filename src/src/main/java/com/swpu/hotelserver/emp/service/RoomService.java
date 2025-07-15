package com.swpu.hotelserver.emp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.hotelserver.emp.dto.RoomCheckPageDTO;
import com.swpu.hotelserver.emp.entity.Room;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huchengbo
 * @since 2024-07-24
 */
public interface RoomService{
    public List<Room> listAllRooms();
    public Room getRoomById(Integer roomNum);
    public boolean addRoom(Room room);
    public boolean updateRoom(Room room);
    public boolean deleteRoom(Integer roomNum);

    List<Room> getRoomByType(String type);

    List<Room> getRoomByStatus(Integer status);
    Page<Room> getRoomCheckPage(RoomCheckPageDTO roomCheckPageDTO);
    Page<Room> pageQuery(Page<Room> page, Room roomFilter);
}

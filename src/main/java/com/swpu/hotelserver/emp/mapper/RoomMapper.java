package com.swpu.hotelserver.emp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swpu.hotelserver.emp.entity.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huchengbo
 * @since 2024-07-24
 */
@Mapper
public interface RoomMapper extends BaseMapper<Room> {
    @Select("select * from room")
    List<Room> listAllRooms();

    @Select("select * from room where room_num = #{roomNum}")
    Room getRoomById(Integer roomNum);

    @Insert("INSERT INTO room (room_num, type, price, description, status) VALUES (#{roomNum}, #{type}, #{price}, #{description}, #{status})")
    boolean addRoom(Room room);

    @Delete("DELETE FROM room WHERE room_num = #{roomNum}")
    boolean deleteRoom(Integer roomNum);

    boolean updateRoom(Room room);
}

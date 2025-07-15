package com.swpu.hotelserver.emp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swpu.hotelserver.emp.entity.Form;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;

@Mapper
public interface FormMapper extends BaseMapper<Form> {

    @Select("select status from room where room_num=#{roomNum};")
    int getRoomStatus(String roomNum);

    @Update("update room set status=2 where room_num=#{roomNum}")
    void setStatus(String roomNum);

    @Update("update room set status=1 where room_num=#{roomNum}")
    void checkOut(String roomNum);

    @Update("update form set end_time=#{hours} where id=#{id}")
    void reIn(Integer id, LocalDateTime hours);

    @Select("select end_time from form where id=#{id}")
    LocalDateTime getEndTime(Integer id);
    @Update("update form set status=1 where id=#{id}")
    void updateStatus(Integer id);
    @Select("select room_num from form where id=#{id};")
    String getRoomNum(Integer id);
}

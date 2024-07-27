package com.swpu.hotelserver.emp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.hotelserver.emp.dto.OrderPageDTO;
import com.swpu.hotelserver.emp.dto.pageRoomOrderDTO;
import com.swpu.hotelserver.emp.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    Page<pageRoomOrderDTO> pageQuery(Page<OrderPageDTO>page, OrderPageDTO orderPageDTO, String startTimeStr, String endTimeStr);
}

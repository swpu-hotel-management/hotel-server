package com.swpu.hotelserver.emp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swpu.hotelserver.emp.dto.AddOrderDTO;
import com.swpu.hotelserver.emp.dto.OrderPageDTO;
import com.swpu.hotelserver.emp.dto.pageRoomOrderDTO;
import com.swpu.hotelserver.emp.entity.Order;
import com.swpu.hotelserver.emp.mapper.OrderMapper;
import com.swpu.hotelserver.emp.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 订单分页查询
     * @param orderPageDTO
     * @return
     */
    @Override
    public IPage<pageRoomOrderDTO> pageQuery(OrderPageDTO orderPageDTO) {

        Page<OrderPageDTO> p = new Page<>(orderPageDTO.getPage(), orderPageDTO.getPageSize());
        String startTimeStr = null;
        String endTimeStr = null;
//        if(!ObjectUtils.isEmpty(orderPageDTO.getOrderNum())){
//            wrapper.like("order_num", orderPageDTO.getOrderNum());
//        }
//        if(!ObjectUtils.isEmpty(orderPageDTO.getClientName())){
//            wrapper.like("client_name", orderPageDTO.getClientName());
//        }
        if(!ObjectUtils.isEmpty(orderPageDTO.getCreateTime())){
            // 使用Calendar来获取当天的开始和结束时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(orderPageDTO.getCreateTime());
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0); // 开始时间

            Calendar endTimeCalendar = Calendar.getInstance();
            endTimeCalendar.setTime(calendar.getTime());
            endTimeCalendar.add(Calendar.DAY_OF_MONTH, 1); // 结束时间是下一天的开始，所以需要加一天
            endTimeCalendar.add(Calendar.MILLISECOND, -1); // 减去1毫秒，确保是当天的最后一毫秒

            // 转换为数据库可识别的日期时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            startTimeStr = sdf.format(calendar.getTime());
            endTimeStr = sdf.format(endTimeCalendar.getTime());

//            wrapper.between("create_time", startTimeStr, endTimeStr);
        }
        Page<pageRoomOrderDTO> orderPage = orderMapper.pageQuery(p,orderPageDTO,startTimeStr,endTimeStr);
        return orderPage;
    }

    @Override
    public boolean addOrder(AddOrderDTO addOrderDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(addOrderDTO,order);
        return this.save(order);
    }


}

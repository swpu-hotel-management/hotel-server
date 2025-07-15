package com.swpu.hotelserver.emp.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.hotelserver.emp.dto.AddOrderDTO;
import com.swpu.hotelserver.emp.dto.OrderPageDTO;
import com.swpu.hotelserver.emp.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService extends IService<Order> {

    /**
     * 订单分页查询
     * @param orderPageDTO
     * @return
     */
    Page<Order> pageQuery(OrderPageDTO orderPageDTO);

    boolean addOrder(AddOrderDTO addOrderDTO);

}

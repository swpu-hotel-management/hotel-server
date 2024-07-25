package com.swpu.hotelserver.emp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swpu.hotelserver.emp.dto.AddOrderDTO;
import com.swpu.hotelserver.emp.dto.OrderPageDTO;
import com.swpu.hotelserver.emp.entity.Order;
import com.swpu.hotelserver.emp.mapper.OrderMapper;
import com.swpu.hotelserver.emp.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 订单分页查询
     * @param orderPageDTO
     * @return
     */
    @Override
    public Page<Order> pageQuery(OrderPageDTO orderPageDTO) {

        Page<Order> p = new Page<>(orderPageDTO.getPage(), orderPageDTO.getPageSize());
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        if(!ObjectUtils.isEmpty(orderPageDTO.getOrderNum())){
            wrapper.like("orderNum", orderPageDTO.getOrderNum());
        }
        Page<Order> orderPage = this.page(p,wrapper);
        return orderPage;
    }

    @Override
    public boolean addOrder(AddOrderDTO addOrderDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(addOrderDTO,order);
        return this.save(order);
    }


}

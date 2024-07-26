package com.swpu.hotelserver.emp.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.swpu.hotelserver.common.result.Result;
import com.swpu.hotelserver.emp.dto.AddOrderDTO;
import com.swpu.hotelserver.emp.dto.OrderDeleteDTO;
import com.swpu.hotelserver.emp.dto.OrderPageDTO;
import com.swpu.hotelserver.emp.dto.pageRoomOrderDTO;
import com.swpu.hotelserver.emp.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/order")
//@Api("订单相关接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单分页查询
     * @param orderPageDTO
     * @return
     */
    @GetMapping("/page")
//    @ApiOperation("订单分页查询")
    public Result<?> page(OrderPageDTO orderPageDTO){
        log.info("分页查询，参数：{}",orderPageDTO);
        IPage<pageRoomOrderDTO> page = orderService.pageQuery(orderPageDTO);
        JSONObject obj = new JSONObject();
        obj.put("total",page.getTotal());
        obj.put("rows",page.getRecords());
        return new Result<>().success().put(obj);
    }

    /**
     * 新建订单
     * @param addOrderDTO
     * @return
     */
    @PostMapping("/add")
//    @ApiOperation("新建订单")
    public Result<?> addOrder(@RequestBody AddOrderDTO addOrderDTO){
        log.info("添加订单，信息：{}",addOrderDTO);
        boolean b = orderService.addOrder(addOrderDTO);
        return b?new Result<>().success().put("添加成功"):new Result<>().error().put("添加失败");
    }

    /**
     * 删除订单
     * @param orderDeleteDTO
     * @return
     */
    @PostMapping("/delete")
//    @ApiOperation("删除订单")
    public Result<?> deleteOrder(@RequestBody OrderDeleteDTO orderDeleteDTO){
        log.info("删除订单,ids:{}",orderDeleteDTO);
        boolean b = orderService.removeByIds(orderDeleteDTO.getIds());
        return b?new Result<>().success("删除成功"):new Result<>().error("删除失败");
    }


}

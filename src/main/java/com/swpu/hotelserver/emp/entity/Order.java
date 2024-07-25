package com.swpu.hotelserver.emp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("order_form")
public class Order {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("room_id")
    private Integer roomId;
    @TableField("client_id")
    private Integer clientId;
    @TableField("order_num")
    private String orderNum;
    @TableField("create_time")
    private LocalDateTime createTime;
}

package com.swpu.hotelserver.emp.dto;

import com.swpu.hotelserver.emp.vo.DataTurnoverPair;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderStatisticDTO {
    private Integer orderNumToday;
    private Integer orderNumYesterday;
    private Integer orderNumWeek;
    private Integer orderNumMonth;
    private Integer dayTurnover;
    private Integer weekTurnover;
    private Integer monthTurnover;
    private Integer yesterdayTurnover;
    private Integer orderNumLastWeek;
    private Integer lastWeekTurnover;
    private Integer orderNumLastMonth;
    private Integer lastMonthTurnover;
    private BigDecimal orderNumPerWeek;
    private BigDecimal orderNumPerMonth;
    private BigDecimal orderTurnoverPerWeek;
    private BigDecimal orderTurnoverPerMonth;
    private List<DataTurnoverPair> dataTurnoverPairList;
}

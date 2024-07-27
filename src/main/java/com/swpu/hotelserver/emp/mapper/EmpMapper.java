package com.swpu.hotelserver.emp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swpu.hotelserver.emp.dto.EmpExample;
import com.swpu.hotelserver.emp.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hotel
 * @since 2024-07-24
 */
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
    Boolean updateEmpRole(@Param("empExample") EmpExample empExample);

    Boolean addEmpRole(@Param("emps") Emp emps);
    Boolean removeEmpRole(Integer id);


}

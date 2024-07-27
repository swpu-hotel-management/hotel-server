package com.swpu.hotelserver.emp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swpu.hotelserver.emp.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hotel
 * @since 2024-07-26
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("SELECT role.role_name FROM role")
    List<String> selectAllNames();

    Boolean removeEmpRole(Integer id);


}

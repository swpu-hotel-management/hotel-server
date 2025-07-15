package com.swpu.hotelserver.emp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.hotelserver.emp.dto.QuseryPagePosition;
import com.swpu.hotelserver.emp.dto.RoleExample;
import com.swpu.hotelserver.emp.entity.Role;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hotel
 * @since 2024-07-26
 */
public interface RoleService extends IService<Role> {
    Page<Role> getPagePosition(QuseryPagePosition quseryPagePosition);
    boolean addRole(RoleExample roleExample);

    List<String> getAllname();
    Boolean removeEmpRole(Integer id);

}

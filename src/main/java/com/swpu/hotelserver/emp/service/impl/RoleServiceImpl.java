package com.swpu.hotelserver.emp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swpu.hotelserver.emp.dto.QuseryPagePosition;
import com.swpu.hotelserver.emp.dto.RoleExample;
import com.swpu.hotelserver.emp.entity.Role;
import com.swpu.hotelserver.emp.mapper.RoleMapper;
import com.swpu.hotelserver.emp.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hotel
 * @since 2024-07-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public Page<Role> getPagePosition(QuseryPagePosition quseryPagePosition) {
        Page<Role> p=new Page<>(quseryPagePosition.getPageNumber(), quseryPagePosition.getPageSize());
        QueryWrapper<Role> queryWrapper=new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(quseryPagePosition.getRoleName())){
            queryWrapper.like("role_name",quseryPagePosition.getRoleName());
        }
        Page<Role> page = this.page(p, queryWrapper);
        return page;
    }
    @Override
    public boolean addRole(RoleExample roleExample) {
        Role role=new Role();

        BeanUtils.copyProperties(roleExample,role);
        return this.save(role);
    }

    @Override
    public List<String> getAllname() {
        return roleMapper.selectAllNames();

    }

    @Override
    public Boolean removeEmpRole(Integer id) {
        return roleMapper.removeEmpRole(id);
    }
}

package com.swpu.hotelserver.emp.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.hotelserver.common.result.Result;
import com.swpu.hotelserver.emp.dto.QuseryPagePosition;
import com.swpu.hotelserver.emp.dto.RoleExample;
import com.swpu.hotelserver.emp.entity.Role;
import com.swpu.hotelserver.emp.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hotel
 * @since 2024-07-26
 */
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/positionPage")
    public Result<?> page(QuseryPagePosition quseryPagePosition){
        Page<Role> pageUser = roleService.getPagePosition(quseryPagePosition);
        JSONObject obj=new JSONObject();
        obj.put("total",pageUser.getTotal());
        obj.put("rows",pageUser.getRecords());
        return new Result<>().success().put(obj);

    }
    @PostMapping("/add")
    public Result<?> addRole(@RequestBody RoleExample roleExample){
        log.info("roleExample:{}", roleExample);
        boolean b = roleService.addRole(roleExample);
        return b?new Result<>().success().put("添加成功"):new Result<>().error().put("添加失败");
    }


    @PostMapping("/update")
    public Result<?> updateRole(@RequestBody RoleExample roleExample){

        log.info("roleExample:{}", roleExample);

            Role role = new Role();
            BeanUtils.copyProperties(roleExample, role);
            boolean b = roleService.updateById(role);
            return b ? new Result<>().success().put("修改成功") : new Result<>().error().put("修改失败");


    }
    @GetMapping("/delete")
    public Result<?> deleteRole(Integer id){
        if(!roleService.removeEmpRole(id)) {
            boolean b = roleService.removeById(id);
            return b ? new Result<>().success().put("删除成功") : new Result<>().error().put("删除失败");
        }
        else return new Result<>().error().put("请先删除或更改有此身份的人");
    }
    @GetMapping("/getRoleName")
    public Result<?> getRoles(){

       List<String> names=roleService.getAllname();
       return new Result<>().success().put(names);


    }

}

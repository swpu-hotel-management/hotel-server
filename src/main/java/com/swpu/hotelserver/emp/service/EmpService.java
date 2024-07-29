package com.swpu.hotelserver.emp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.hotelserver.emp.dto.EmpExample;
import com.swpu.hotelserver.emp.dto.LoginUser;
import com.swpu.hotelserver.emp.dto.QuseryPageEmp;
import com.swpu.hotelserver.emp.entity.Emp;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hotel
 * @since 2024-07-24
 */
public interface EmpService extends IService<Emp> {
    Emp login(LoginUser loginuser);

    String getVcode();

    boolean checkVcode(String vocode);

    String getPasswordByusername(String username);

    Page<Emp> getPageUser(QuseryPageEmp quseryPageEmp);



    String saveEmpImg(MultipartFile file);

    boolean addEmp(EmpExample empExample);

    boolean updateEmp(EmpExample empExample);

    Boolean removeEmpRole(Integer id);

    Boolean showEmpmenu(Integer id);

}

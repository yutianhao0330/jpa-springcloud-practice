package com.yutianhao.yutianhaouserservice.service.impl;

import com.yutianhao.yutianhaocommon.entity.Department;
import com.yutianhao.yutianhaouserservice.dao.DeptRepository;
import com.yutianhao.yutianhaouserservice.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thyu
 * @title: DeptServiceImpl
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 8:32
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptRepository deptRepository;

    @Override
    public List<Department> list() {
        return deptRepository.findAll();
    }
}

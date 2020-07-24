package com.yutianhao.yutianhaouserservice.service;

import com.yutianhao.yutianhaocommon.entity.Department;

import java.util.List;

/**
 * @author thyu
 * @title: DeptService
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 8:32
 */
public interface DeptService {
    List<Department> list();
}

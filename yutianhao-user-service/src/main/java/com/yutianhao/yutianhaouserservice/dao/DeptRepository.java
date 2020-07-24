package com.yutianhao.yutianhaouserservice.dao;

import com.yutianhao.yutianhaocommon.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author thyu
 * @title: DeptRepository
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 8:31
 */
public interface DeptRepository extends JpaRepository<Department,Integer> {

}

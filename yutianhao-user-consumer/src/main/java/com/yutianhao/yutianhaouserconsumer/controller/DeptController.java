package com.yutianhao.yutianhaouserconsumer.controller;

import com.yutianhao.yutianhaocommon.entity.Department;
import com.yutianhao.yutianhaouserconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author thyu
 * @title: DeptService
 * @projectName yutianhao-eureka-jpa-demo
 * @description: TODO
 * @date 2020/7/24 8:36
 */
@RestController
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private UserService userService;
    @RequestMapping("list")
    public List<Department> list(){
        return userService.deptList();
    }

}
